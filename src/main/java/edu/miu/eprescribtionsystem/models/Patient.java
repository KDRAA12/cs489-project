package edu.miu.eprescribtionsystem.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Patient {
    @GeneratedValue
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated
    private Gender gender;
    private String email;
    private String phoneNumber;
}
