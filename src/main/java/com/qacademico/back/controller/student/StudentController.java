package com.qacademico.back.controller.student;

import com.qacademico.back.controller.student.request.CreateStudentRequest;
import com.qacademico.back.controller.student.request.StudentRequest;
import com.qacademico.back.controller.student.request.UpdateStudentRequest;
import com.qacademico.back.controller.student.response.CreateStudentResponse;
import com.qacademico.back.controller.student.response.StudentResponse;
import com.qacademico.back.controller.student.response.UpdateStudentResponse;
import com.qacademico.back.services.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController

public class StudentController implements StudentAPI {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = Objects.requireNonNull(studentService);
    }

    @Override
    public CreateStudentResponse createStudent(CreateStudentRequest input) {
        return this.studentService.create(input);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return this.studentService.getStudents()
                .stream().map(StudentResponse::fromStudent)
                .toList();
    }

    @Override
    public StudentResponse getById(final String anId) {
        return this.studentService.getStudent(anId).get();
    }

    @Override
    public UpdateStudentResponse updateById(String anId, UpdateStudentRequest input) {
        return this.studentService.updateStudent(anId, input);
    }

    @Override
    public void deleteById(final String anId) {
        this.studentService.deleteStudent(anId);
    }
}
