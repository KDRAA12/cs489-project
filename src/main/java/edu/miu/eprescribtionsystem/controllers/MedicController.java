package edu.miu.eprescribtionsystem.controllers;


import edu.miu.eprescribtionsystem.Services.MedicService;
import edu.miu.eprescribtionsystem.models.Medic;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/medics")
public class MedicController {
    private final MedicService medicService;

    @GetMapping
    public Page<Medic> findAll(Pageable pageable){
        return medicService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Medic findById(Long id){
        return medicService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medic save(@RequestBody Medic medic){
        return medicService.save(medic);
    }

    @PutMapping("/{id}")
    public Medic update(@PathVariable Long id,@RequestBody Medic medic){
        return medicService.update(id,medic);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         medicService.deleteById(id);
    }







}
