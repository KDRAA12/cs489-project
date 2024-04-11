package edu.miu.eprescribtionsystem.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @Column(unique = true)
    private String username;
    private String password;

//    private L<String> roles =new ArrayList<>();

}
