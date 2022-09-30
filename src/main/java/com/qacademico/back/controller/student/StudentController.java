package com.qacademico.back.controller.student;

import com.qacademico.back.controller.student.request.StudentRequest;
import com.qacademico.back.controller.student.response.StudentResponse;
import com.qacademico.back.services.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController

public class StudentController implements StudentAPI {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = Objects.requireNonNull(studentService);
    }

    @Override
    public StudentResponse createStudent(StudentRequest input) {
        final var aStudente = this.studentService.create(input.toStudent());
        return new StudentResponse().fromStudent(aStudente);
    }

    @Override
    public StudentResponse getById(String id) {
        return null;
    }

    @Override
    public StudentResponse updateById(String id, StudentRequest input) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
