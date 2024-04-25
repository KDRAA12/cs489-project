package edu.miu.eprescribtionsystem.Services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import edu.miu.eprescribtionsystem.exceptions.NotFoundException;
import edu.miu.eprescribtionsystem.models.*;
import edu.miu.eprescribtionsystem.repositories.BasicPrescriptionRepository;
import edu.miu.eprescribtionsystem.repositories.TemplatePrescriptionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PrescriptionService {
    private final BasicPrescriptionRepository basicPrescriptionRepository;
    private final TemplatePrescriptionRepository templatePrescriptionRepository;
    private final PatientService    patientService;
    private final MedicService medicService;
    private final MediaService mediaService;
    private final PdfServices pdfServices;
    private final TemplateEngine templateEngine;
    private final PrescriptionHeaderService prescriptionHeaderService;




    public BasicPrescription findById(Long id) {
        return basicPrescriptionRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public TemplatePrescription findTemplateById(Long id) {
        return templatePrescriptionRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    public void deleteTemplate(Long id) {
        TemplatePrescription templatePrescription = findTemplateById(id);
        templatePrescriptionRepository.delete(templatePrescription);
    }

    private void setPrescriptionData(Prescription prescription){

    }

    private void getneratePdf(Prescription prescription){

    }

    public byte[] generatePdf(BasicPrescription prescription) {
        String html = this.processedHtmlFormPrescription(prescription);
        byte[] pdf = pdfServices.convertHtmlToPdf(html, "A5");
        String url = mediaService.saveFile(pdf);
        prescription.setPdfUrl(url);
        basicPrescriptionRepository.save(prescription);
        return pdf;
    }


    private String processedHtmlFormPrescription(BasicPrescription prescription) {
        PrescriptionHeader header=prescriptionHeaderService.findById(prescription.getHeader().getId());
        prescription.setHeader(header);
        List<PrescriptionHeaderLine> left = prescription.getHeader()
                .getLines()
                .stream()
                .filter(prescriptionHeaderLine -> prescriptionHeaderLine.getPosition()
                        .equals(PrescriptionHeaderLinePosition.LEFT))
                .sorted((a, b) -> a.getLineNumber().compareTo(b.getLineNumber()))
                .collect(Collectors.toList());

        List<PrescriptionHeaderLine> right = prescription.getHeader()
                .getLines()
                .stream()
                .filter(prescriptionHeaderLine -> prescriptionHeaderLine.getPosition()
                        .equals(PrescriptionHeaderLinePosition.RIGHT))
                .sorted((a, b) -> a.getLineNumber().compareTo(b.getLineNumber()))
                .collect(Collectors.toList());

        long numberOfPrescription = basicPrescriptionRepository
                .countPrescriptionByPatient(prescription.getPatient());
        Context ctx = new Context();

        try {
            String qrcode = "data:image/png;base64," + Base64.getEncoder().encodeToString(
                    generateQRCode(
                            "prescriptions/download-pdf/" + prescription.getId())
                    );
            ctx.setVariable("prescription", prescription);
            ctx.setVariable("qrCode", qrcode);
//            ctx.setVariable("doctor", prescription.get);
            ctx.setVariable("numberOfPrescription", numberOfPrescription);
            ctx.setVariable("left", left);
            ctx.setVariable("right", right);
            ctx.setVariable("year", OffsetDateTime.now().getYear());
            ctx.setVariable("date", prescription.getCreatedAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

            if (prescription.getHeader().getLogo() != null)
                ctx.setVariable("logo",prescription.getHeader().getLogo());
            return templateEngine.process("prescription", ctx);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] generateQRCode(String url) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(url.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8), BarcodeFormat.QR_CODE, 200,
                200);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "png", bos);
        return bos.toByteArray();
    }

    public byte[] downloadPdf(Long id) {
        BasicPrescription prescription =  basicPrescriptionRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        return generatePdf(prescription);
    }

    public String previewPdf(Long id) {
        BasicPrescription prescription =  basicPrescriptionRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        return this.processedHtmlFormPrescription(prescription);
    }


    @Transactional
    public Prescription save(
                             Prescription prescription,
                             String name
                            ) {



        if (prescription.getItems() != null) {
            // Batch save prescription items
            List<Medic> newDrugs = prescription.getItems().stream()
                    .map(PrescriptionItem::getMedic)
                    .filter(medic -> medic.getId() == null)
                    .collect(Collectors.toList());

            if (!newDrugs.isEmpty()) {
                List<Medic> savedDrugs =medicService.save(newDrugs);
                Map<String, Medic> drugMap = savedDrugs.stream()
                        .collect(Collectors.toMap(Medic::getName, Function.identity()));

                prescription.getItems().forEach(prescriptionItem -> {
                    if (prescriptionItem.getMedic() == null) {
                        prescriptionItem.setDrugName(drugMap.get(prescriptionItem.getDrugName()).getName());
                    }
                });
            }
        }

//        if (name!=null) {
//            TemplatePrescription templatePrescription = new TemplatePrescription();
//            System.out.println("saving prescription items");
//
//            templatePrescription.setItems(List.copyOf(prescription.getItems()));
//            templatePrescription.setName(name);
//            templatePrescription.setCreatedBy(prescription.getCreatedBy());
//            templatePrescription = templatePrescriptionRepository.save(templatePrescription);
//            if (prescription.getType().equals(PrescriptionType.template)) {
//                return templatePrescription;
//            }
//        }

        BasicPrescription basicPrescription=(BasicPrescription) prescription;

        if (basicPrescription.getPatient().getId() == null) {
            Optional<Patient> patient = patientService.findByPhoneNumber(basicPrescription.getPatient().getPhoneNumber());
            if (patient.isEmpty()) {
                Patient savedPatient = patientService.save(basicPrescription.getPatient());
                basicPrescription.setPatient(savedPatient);            }
        }

        System.out.println(basicPrescription);
        System.out.println("saving prescription items");
        basicPrescription.getItems().forEach(x->x.setId(null));
        BasicPrescription result = basicPrescriptionRepository.saveAndFlush(basicPrescription);

        if (result.getPatient() != null) {
            getneratePdf(result);
        }

        return null;
    }


    public Page<? extends Prescription> findAll(PrescriptionType type, Pageable pageable) {
        if(PrescriptionType.template.equals(type)){
            return templatePrescriptionRepository.findAll(pageable);
        }
        return templatePrescriptionRepository.findAll(pageable);
    }
}
