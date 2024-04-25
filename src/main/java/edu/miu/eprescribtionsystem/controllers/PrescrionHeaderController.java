package edu.miu.eprescribtionsystem.controllers;

import edu.miu.eprescribtionsystem.Services.PrescriptionHeaderService;
import edu.miu.eprescribtionsystem.models.PrescriptionHeader;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/headers")
@AllArgsConstructor
public class PrescrionHeaderController {
    private final PrescriptionHeaderService prescriptionHeaderService;


    @GetMapping
    private Page<PrescriptionHeader> findAll(Pageable pageable){
        return prescriptionHeaderService.findAll(pageable);
    }

    @PostMapping
    private PrescriptionHeader save(@RequestBody PrescriptionHeader prescriptionHeader){
        return prescriptionHeaderService.save(prescriptionHeader);
    }
}
