package com.qacademico.back.controller.student.response;

import com.qacademico.back.model.Student;
import lombok.Getter;

@Getter
public class StudentResponse {

    private String id;
    private String enroll;
    private String course;
    private String name;
    private String email;
    private String phone;
    private String address;

    private StudentResponse(String id, String enroll, String course, String name, String email, String phone, String address) {
        this.id = id;
        this.enroll = enroll;
        this.course = course;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public static StudentResponse fromStudent(final Student aStudent) {
        return new StudentResponse(
                aStudent.getId(),
                aStudent.getEnroll(),
                aStudent.getCourse(),
                aStudent.getName(),
                aStudent.getEmail(),
                aStudent.getPhone(),
                aStudent.getAddress()
        );
    }
}
