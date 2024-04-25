package edu.miu.eprescribtionsystem.Services;


import edu.miu.eprescribtionsystem.exceptions.NotFoundException;
import edu.miu.eprescribtionsystem.models.MedicCategory;
import edu.miu.eprescribtionsystem.repositories.MedicCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MedicCategoryService {
    private final MedicCategoryRepository medicCategoryRepository;

    public MedicCategory save(MedicCategory medicCategory){
        return medicCategoryRepository.save(medicCategory);
    }

    public MedicCategory findById(Long id){
        return medicCategoryRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteById(Long id){
        MedicCategory medicCategory=findById(id);
        medicCategoryRepository.delete(medicCategory);
    }

    public MedicCategory update(Long id, MedicCategory medicCategory) {
        MedicCategory medicCategory1 = findById(id);
        medicCategory.setId(id);
        return medicCategoryRepository.save(medicCategory);
    }

    public Page<MedicCategory> findAll(Pageable pageable){
        return medicCategoryRepository.findAll(pageable);
    }


}


