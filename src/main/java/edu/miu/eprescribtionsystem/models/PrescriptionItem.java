package edu.miu.eprescribtionsystem.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PrescriptionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String drugName;
    @ManyToOne
    private Medic medic;
    private String quantityUnit;
    private int quantity;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<TimeOfTake> timesOfTake;
    @Enumerated(value = EnumType.STRING)
    private DurationUnit durationUnit;
    private int duration;
    @Column(columnDefinition = "TEXT")
    private String text;
    @Column(columnDefinition = "TEXT")
    private String instruction;
}
