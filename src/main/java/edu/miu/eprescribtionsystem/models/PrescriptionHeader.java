package edu.miu.eprescribtionsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class PrescriptionHeader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logo;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PrescriptionHeaderLine> lines;

    public List<PrescriptionHeaderLine> getRightLines() {
        return lines
                .stream()
                .filter(prescriptionHeaderLine -> prescriptionHeaderLine.getPosition()
                        .equals(PrescriptionHeaderLinePosition.RIGHT))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<PrescriptionHeaderLine> getLeftLine() {
        return lines
                .stream()
                .filter(prescriptionHeaderLine -> prescriptionHeaderLine.getPosition()
                        .equals(PrescriptionHeaderLinePosition.LEFT))
                .sorted()
                .collect(Collectors.toList());
    }
}
