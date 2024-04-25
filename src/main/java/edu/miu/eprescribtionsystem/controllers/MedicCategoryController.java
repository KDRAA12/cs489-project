package edu.miu.eprescribtionsystem.controllers;


import edu.miu.eprescribtionsystem.Services.MedicCategoryService;
import edu.miu.eprescribtionsystem.models.MedicCategory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medics/categories")
@AllArgsConstructor
public class MedicCategoryController {
    private final MedicCategoryService medicCategoryService;

    @GetMapping
    public Page<MedicCategory> findAll(Pageable pageable){
        return medicCategoryService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public MedicCategory findById(Long id){
        return medicCategoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Long id){
        medicCategoryService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicCategory save(MedicCategory medicCategory){
        return medicCategoryService.save(medicCategory);
    }

    @PutMapping("/{id}")
    public MedicCategory update(Long id, MedicCategory medicCategory){
        return medicCategoryService.update(id, medicCategory);
    }






}
