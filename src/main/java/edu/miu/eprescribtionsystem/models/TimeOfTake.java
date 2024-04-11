package edu.miu.eprescribtionsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeOfTake {
    @Id
    @GeneratedValue
    private Long id;
    private DurationUnit unit;
    private float amount;
    @Enumerated(value = EnumType.STRING)
    private DurationUnit durationUnit;
}
