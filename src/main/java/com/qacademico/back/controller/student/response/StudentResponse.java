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


    public StudentResponse from(final Student aStudent) {
        this.id = aStudent.getId();
        this.enroll = aStudent.getEnroll();
        this.course = aStudent.getCourse();
        this.name = aStudent.getName();
        this.email = aStudent.getEmail();
        this.phone = aStudent.getPhone();
        this.address = aStudent.getAddress();

        return this;
    }
}
