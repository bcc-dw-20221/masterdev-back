package com.qacademico.back.controller.student;

import com.qacademico.back.controller.student.request.CreateStudentRequest;
import com.qacademico.back.controller.student.response.StudentResponse;
import com.qacademico.back.services.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse create(@RequestBody CreateStudentRequest request) {
        final var aStudent = studentService.create(request.toStudent());
        return new StudentResponse().from(aStudent);
    }

    @GetMapping
    public List<StudentResponse> getAll() {
        return  this.studentService.getStudents();
    }
}
