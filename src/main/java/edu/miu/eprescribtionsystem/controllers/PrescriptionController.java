package edu.miu.eprescribtionsystem.controllers;


import edu.miu.eprescribtionsystem.Services.PrescriptionService;
import edu.miu.eprescribtionsystem.Services.UserService;
import edu.miu.eprescribtionsystem.models.BasicPrescription;
import edu.miu.eprescribtionsystem.models.Prescription;
import edu.miu.eprescribtionsystem.models.PrescriptionType;
import edu.miu.eprescribtionsystem.models.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/prescriptions")
@RestController
@AllArgsConstructor
public class PrescriptionController {
    private final PrescriptionService prescriptionService;
    private UserService userService;



    @GetMapping
    public Page<? extends Prescription> findAll(Pageable pageable,
                                                @RequestParam PrescriptionType type){
        return prescriptionService.findAll(type,pageable);
    }


    @PostMapping
    public Prescription prescription(@RequestBody BasicPrescription prescription, @RequestParam(required = false)  String name){
        User user=userService.findById("1234");
        prescription.setCreatedBy(user);
        return prescriptionService.save(prescription,name);
    }


}
