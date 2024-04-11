package edu.miu.eprescribtionsystem.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MedicCategory {
    @Id
    @GeneratedValue
    private Long id;
    private String label;
    @Column(length = 500)
    private String description;
}
