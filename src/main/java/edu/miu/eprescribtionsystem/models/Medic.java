package edu.miu.eprescribtionsystem.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medic {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String usage;

    @ManyToOne
    private MedicCategory category;


}
