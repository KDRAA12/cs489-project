package edu.miu.eprescribtionsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class PrescriptionHeaderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Integer lineNumber;
    @Enumerated(value = EnumType.STRING)
    private PrescriptionHeaderLinePosition position;
}
