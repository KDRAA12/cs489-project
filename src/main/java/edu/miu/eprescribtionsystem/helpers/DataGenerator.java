package edu.miu.eprescribtionsystem.helpers;


import edu.miu.eprescribtionsystem.Services.PrescriptionHeaderService;
import edu.miu.eprescribtionsystem.Services.UserService;
import edu.miu.eprescribtionsystem.models.*;
import edu.miu.eprescribtionsystem.repositories.MedicCategoryRepository;
import edu.miu.eprescribtionsystem.repositories.MedicRepository;
import edu.miu.eprescribtionsystem.repositories.PatientRepository;
import edu.miu.eprescribtionsystem.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataGenerator {
    private final MedicCategoryRepository medicCategoryRepository;
    private final MedicRepository medicRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;
    private final PrescriptionHeaderService prescriptionHeaderService;

    public void generateUsers(){
        userRepository.save(new User("abdel.lavdal@gmail.com","1234"));
    }



    public void initializeDatabase() {
//        MedicCategory antibiotic = medicCategoryRepository.save(new MedicCategory(null,"Antibiotic", "Used to treat bacterial infections."));
//        MedicCategory analgesic = medicCategoryRepository.save(new MedicCategory(null,"Analgesic", "Used for relief from pain."));
//        MedicCategory antiseptic = medicCategoryRepository.save(new MedicCategory(null,"Antiseptic", "Used to prevent the growth of disease-causing microorganisms."));
//        MedicCategory antipyretic = medicCategoryRepository.save(new MedicCategory(null,"Antipyretic", "Used to prevent or reduce fever."));
//        MedicCategory antihistamine = medicCategoryRepository.save(new MedicCategory(null,"Antihistamine", "Used to treat allergic reactions."));
//
//        List<Patient> patients = List.of(
//                new Patient(null, "John", "Doe", Gender.MALE, "john.doe@example.com", "1234567890"),
//                new Patient(null, "Jane", "Doe", Gender.FEMALE, "jane.doe@example.com", "0987654321"),
//                new Patient(null, "Sam", "Smith", Gender.MALE, "sam.smith@example.com", "1122334455"),
//                new Patient(null, "Alice", "Johnson", Gender.FEMALE, "alice.johnson@example.com", "2233445566"),
//                new Patient(null, "Bob", "Brown", Gender.MALE, "bob.brown@example.com", "3344556677"),
//                new Patient(null, "Charlie", "Davis", Gender.MALE, "charlie.davis@example.com", "4455667788"),
//                new Patient(null, "Daisy", "Miller", Gender.FEMALE, "daisy.miller@example.com", "5566778899"),
//                new Patient(null, "Ethan", "Wilson", Gender.MALE, "ethan.wilson@example.com", "6677889900"),
//                new Patient(null, "Fiona", "Taylor", Gender.FEMALE, "fiona.taylor@example.com", "7788990011"),
//                new Patient(null, "George", "Anderson", Gender.MALE, "george.anderson@example.com", "8899001122")
//        );
//
//        patientRepository.saveAll(patients);
//
//        medicRepository.saveAll(List.of(
//                new Medic(null,"Amoxicillin", "Take one tablet three times a day", antibiotic),
//                new Medic(null,"Doxycycline", "Take one tablet daily", antibiotic),
//                new Medic(null,"Cephalexin", "Take one tablet every 8 hours", antibiotic),
//                new Medic(null,"Clindamycin", "Take one capsule every 6 hours", antibiotic),
//                new Medic(null,"Azithromycin", "Take one tablet daily for three days", antibiotic),
//                new Medic(null,"Ciprofloxacin", "Take one tablet twice a day", antibiotic),
//                new Medic(null,"Levofloxacin", "Take one tablet daily", antibiotic),
//                new Medic(null,"Metronidazole", "Take one tablet three times a day", antibiotic),
//                new Medic(null,"Vancomycin", "Take one capsule twice a day", antibiotic),
//                new Medic(null,"Erythromycin", "Take one tablet every 6 hours", antibiotic),
//                new Medic(null,"Ibuprofen", "Take one tablet every 4 to 6 hours as needed", analgesic),
//                new Medic(null,"Aspirin", "Take one to two tablets every 4 to 6 hours", analgesic),
//                new Medic(null,"Acetaminophen", "Take one tablet every 4 to 6 hours as needed", analgesic),
//                new Medic(null,"Naproxen", "Take one tablet two times a day", analgesic),
//                new Medic(null,"Diclofenac", "Take one tablet daily", analgesic),
//                new Medic(null,"Tramadol", "Take one tablet every 6 hours as needed", analgesic),
//                new Medic(null,"Oxycodone", "Take one tablet as prescribed for pain", analgesic),
//                new Medic(null,"Morphine", "Take as directed by healthcare provider", analgesic),
//                new Medic(null,"Celecoxib", "Take one capsule once or twice a day", analgesic),
//                new Medic(null,"Hydrocodone", "Take as prescribed for severe pain", analgesic),
//                new Medic(null,"Hydrogen Peroxide", "Apply a small amount to the affected area", antiseptic),
//                new Medic(null,"Chlorhexidine", "Use as directed for oral rinsing", antiseptic),
//                new Medic(null,"Iodine Solution", "Apply topically to clean wounds", antiseptic),
//                new Medic(null,"Alcohol Rub", "Use to disinfect hands", antiseptic),
//                new Medic(null,"Povidone-Iodine", "Apply to minor wounds and burns", antiseptic),
//                new Medic(null,"Benzalkonium Chloride", "Apply as needed for skin disinfection", antiseptic),
//                new Medic(null,"Thiomersal", "Use as directed for contact lens solutions", antiseptic),
//                new Medic(null,"Cetrimide", "Apply on skin as an antiseptic", antiseptic),
//                new Medic(null,"Phenol", "Use with caution on wounds", antiseptic),
//                new Medic(null,"Boric Acid", "Use as prescribed for eye infections", antiseptic),
//                new Medic(null,"Paracetamol", "Take one tablet every 4 to 6 hours as needed", antipyretic),
//                new Medic(null,"Ibuprofen", "Take one tablet every 6 to 8 hours with food", antipyretic),
//                new Medic(null,"Aspirin", "Take 300-600 mg every 4-6 hours as needed", antipyretic),
//                new Medic(null,"Naproxen", "Take one tablet twice a day with food", antipyretic),
//                new Medic(null,"Acetaminophen", "Take 500 mg every 4-6 hours; do not exceed 3000 mg per day", antipyretic),
//                new Medic(null,"Diclofenac", "Apply gel to affected area four times a day", antipyretic),
//                new Medic(null,"Indomethacin", "Take one capsule two to three times a day with food", antipyretic),
//                new Medic(null,"Ketoprofen", "Take 25 mg three times per day with food", antipyretic),
//                new Medic(null,"Mefenamic Acid", "Take 250 mg every 6 hours with food", antipyretic),
//                new Medic(null,"Celecoxib", "Take one 200 mg capsule once a day", antipyretic),
//                new Medic(null,"Diphenhydramine", "Take 25-50 mg every 4-6 hours as needed", antihistamine),
//                new Medic(null,"Loratadine", "Take one tablet once a day", antihistamine),
//                new Medic(null,"Cetirizine", "Take one tablet once a day", antihistamine),
//                new Medic(null,"Fexofenadine", "Take 180 mg once daily", antihistamine),
//                new Medic(null,"Desloratadine", "Take one tablet once a day", antihistamine),
//                new Medic(null,"Levocetirizine", "Take 5 mg once daily", antihistamine),
//                new Medic(null,"Chlorpheniramine", "Take 4 mg every 4-6 hours as needed", antihistamine),
//                new Medic(null,"Promethazine", "Take 25 mg before bed or 12.5 mg before meals and at bedtime", antihistamine),
//                new Medic(null,"Azelastine", "Spray once or twice in each nostril twice a day", antihistamine),
//                new Medic(null,"Olopatadine", "Apply one drop in each affected eye twice a day", antihistamine)
//        ));


//        PrescriptionHeader header1 = new PrescriptionHeader(
//                null,
//                "logo1.png",
//                Arrays.asList(
//                        new PrescriptionHeaderLine(null, "Hospital Charles William", 1, PrescriptionHeaderLinePosition.LEFT),
//                        new PrescriptionHeaderLine(null, "Department of Cardiology", 2, PrescriptionHeaderLinePosition.LEFT),
//                        new PrescriptionHeaderLine(null, "1234 Street, City", 3, PrescriptionHeaderLinePosition.LEFT),
//                        new PrescriptionHeaderLine(null, "Phone: 123-456-7890", 4, PrescriptionHeaderLinePosition.LEFT),
//                        new PrescriptionHeaderLine(null, "مستشفى تشارلز ويليام", 1, PrescriptionHeaderLinePosition.RIGHT),
//                        new PrescriptionHeaderLine(null, "قسم أمراض القلب", 2, PrescriptionHeaderLinePosition.RIGHT),
//                        new PrescriptionHeaderLine(null, "1234 شارع، مدينة", 3, PrescriptionHeaderLinePosition.RIGHT),
//                        new PrescriptionHeaderLine(null, "هاتف: 123-456-7890", 4, PrescriptionHeaderLinePosition.RIGHT)
//                )
//        );
//        prescriptionHeaderService.save(header1);
//        PrescriptionHeader header2 = new PrescriptionHeader(
//                null,
//                "logo2.png",
//                Arrays.asList(
//                        new PrescriptionHeaderLine(null, "Hospital Green Valley", 1, PrescriptionHeaderLinePosition.LEFT),
//                        new PrescriptionHeaderLine(null, "Department of Neurology", 2, PrescriptionHeaderLinePosition.LEFT),
//                        new PrescriptionHeaderLine(null, "4321 Avenue, Suburb", 3, PrescriptionHeaderLinePosition.LEFT),
//                        new PrescriptionHeaderLine(null, "Phone: 987-654-3210", 4, PrescriptionHeaderLinePosition.LEFT),
//                        new PrescriptionHeaderLine(null, "مستشفى غرين فالي", 1, PrescriptionHeaderLinePosition.RIGHT),
//                        new PrescriptionHeaderLine(null, "قسم الأعصاب", 2, PrescriptionHeaderLinePosition.RIGHT),
//                        new PrescriptionHeaderLine(null, "4321 زقاق، ضاحية", 3, PrescriptionHeaderLinePosition.RIGHT),
//                        new PrescriptionHeaderLine(null, "هاتف: 987-654-3210", 4, PrescriptionHeaderLinePosition.RIGHT)
//                )
//        );
//        prescriptionHeaderService.save(header2);
//
//        PrescriptionHeader header3 = new PrescriptionHeader(
//                null,
//                "logo3.png",
//                Arrays.asList(
//                        new PrescriptionHeaderLine(null, "Hospital Blue Waters", 1, PrescriptionHeaderLinePosition.LEFT),
//                        new PrescriptionHeaderLine(null, "Department of Orthopedics", 2, PrescriptionHeaderLinePosition.LEFT),
//                        new PrescriptionHeaderLine(null, "7890 Boulevard, Coastal City", 3, PrescriptionHeaderLinePosition.LEFT),
//                        new PrescriptionHeaderLine(null, "Phone: 456-123-7890", 4, PrescriptionHeaderLinePosition.LEFT),
//                        new PrescriptionHeaderLine(null, "مستشفى المياه الزرقاء", 1, PrescriptionHeaderLinePosition.RIGHT),
//                        new PrescriptionHeaderLine(null, "قسم العظام", 2, PrescriptionHeaderLinePosition.RIGHT),
//                        new PrescriptionHeaderLine(null, "7890 بوليفارد، المدينة الساحلية", 3, PrescriptionHeaderLinePosition.RIGHT),
//                        new PrescriptionHeaderLine(null, "هاتف: 456-123-7890", 4, PrescriptionHeaderLinePosition.RIGHT)
//                )
//        );
//        prescriptionHeaderService.save(header3);
//


    }
}
