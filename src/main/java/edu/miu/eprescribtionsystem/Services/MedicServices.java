package edu.miu.eprescribtionsystem.Services;


import edu.miu.eprescribtionsystem.exceptions.NotFoundException;
import edu.miu.eprescribtionsystem.models.Medic;
import edu.miu.eprescribtionsystem.repositories.MedicRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicServices{
    private final MedicRepository medicRepository;

    private Page<Medic> findAll(Pageable pageable){
        return medicRepository.findAll(pageable);
    }

    private Medic findById(Long id){
        return medicRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    private Medic save(Medic medic){
        return medicRepository.save(medic);
    }

    private void deleteById(Long id){
        Medic medic=findById(id);
        medicRepository.delete(medic);
    }

    private Medic update(Long id, Medic medic) {
        Medic medic1 = findById(id);
        medic.setId(id);
        return medicRepository.save(medic);
    }

}
