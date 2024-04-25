package edu.miu.eprescribtionsystem.Services;


import edu.miu.eprescribtionsystem.exceptions.NotFoundException;
import edu.miu.eprescribtionsystem.models.PrescriptionHeader;
import edu.miu.eprescribtionsystem.repositories.PrescriptionHeaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PrescriptionHeaderService {

    private final PrescriptionHeaderRepository prescriptionHeaderRepository;
    public PrescriptionHeader save( PrescriptionHeader header) {
      return   prescriptionHeaderRepository.save(header);
    }

    public PrescriptionHeader findById(Long id) {
        return prescriptionHeaderRepository.findById(id).orElseThrow( NotFoundException::new);

    }

    public void deleteById(Long id) {
        PrescriptionHeader header = findById(id);
        prescriptionHeaderRepository.delete(header);
    }

    public PrescriptionHeader update(Long id, PrescriptionHeader header) {
        PrescriptionHeader header1 = findById(id);
        header.setId(id);
        return prescriptionHeaderRepository.save(header);
    }

    public Page<PrescriptionHeader> findAll(Pageable pageable) {
        return prescriptionHeaderRepository.findAll(pageable);
    }
}
