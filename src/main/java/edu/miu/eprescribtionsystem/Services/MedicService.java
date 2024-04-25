package edu.miu.eprescribtionsystem.Services;


import edu.miu.eprescribtionsystem.exceptions.NotFoundException;
import edu.miu.eprescribtionsystem.models.Medic;
import edu.miu.eprescribtionsystem.repositories.MedicRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MedicService{
    private final MedicRepository medicRepository;

    public Page<Medic> findAll(Pageable pageable){
        return medicRepository.findAll(pageable);
    }

    public Medic findById(Long id){
        return medicRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Medic save(Medic medic){
        return medicRepository.save(medic);
    }

    public List<Medic> save(List<Medic> medics){
        return medicRepository.saveAll(medics);
    }


    public void deleteById(Long id){
        Medic medic=findById(id);
        medicRepository.delete(medic);
    }

    public Medic update(Long id, Medic medic) {
        Medic medic1 = findById(id);
        medic.setId(id);
        return medicRepository.save(medic);
    }

}
