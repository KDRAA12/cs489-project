package edu.miu.eprescribtionsystem.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Patient {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated
    private Gender gender;
    private String email;
    private String phoneNumber;
}
