package com.qacademico.back.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    private String id;
    private String enroll;
    private String course;
    private String cpf;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime birthDate;

}
