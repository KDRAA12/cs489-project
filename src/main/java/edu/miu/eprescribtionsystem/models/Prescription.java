package edu.miu.eprescribtionsystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name="type",discriminatorType = DiscriminatorType.STRING)
public abstract class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private PrescriptionType prescriptionType;
    @OneToMany(cascade = CascadeType.ALL)
    private List<PrescriptionItem> items;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime lastUpdate;
    private LocalDateTime deletedAt;
    @ManyToOne(fetch = FetchType.EAGER)
    private User createdBy;
    @Column(insertable = false, updatable = false)
    @Enumerated(value = EnumType.STRING)
    private PrescriptionType type;
}


