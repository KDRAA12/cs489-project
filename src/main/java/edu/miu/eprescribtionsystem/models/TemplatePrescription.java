package edu.miu.eprescribtionsystem.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("template")
@EqualsAndHashCode(callSuper = true)
@Entity
public class TemplatePrescription extends BasicPrescription {
    private String name;


}
