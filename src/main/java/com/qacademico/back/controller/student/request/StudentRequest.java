package com.qacademico.back.controller.student.request;

import com.qacademico.back.model.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class StudentRequest {
    private String name;
    private String email;
    private String cpf;
    private String address;
    private String phone;
    private LocalDateTime birthDate;
    private String password;
    private String enroll;
    private String course;
    public Student toStudent() {

        final var student = new Student();

        student.setName(name);
        student.setEnroll(enroll);
        student.setCourse(course);
        student.setCpf(cpf);
        student.setPassword(password);
        student.setEmail(email);
        student.setPhone(phone);
        student.setAddress(address);
        student.setBirthDate(birthDate);

        return student;
    }
}
