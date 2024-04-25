package edu.miu.eprescribtionsystem.dtos;


import edu.miu.eprescribtionsystem.models.Gender;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    @Enumerated
    private Gender gender;
    private String email;
    private String phoneNumber;

}
