package edu.miu.eprescribtionsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class BasicPrescription extends Prescription{
    private String name;
    private String pdfUrl;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private PrescriptionHeader header;

}
