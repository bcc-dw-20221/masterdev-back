package com.qacademico.back.services.student;


import com.qacademico.back.controller.student.request.CreateStudentRequest;
import com.qacademico.back.controller.student.request.UpdateStudentRequest;
import com.qacademico.back.controller.student.response.CreateStudentResponse;
import com.qacademico.back.controller.student.response.StudentResponse;
import com.qacademico.back.controller.student.response.UpdateStudentResponse;
import com.qacademico.back.model.Student;
import com.qacademico.back.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponse create(final CreateStudentRequest aStudent) {
        final var student = this.studentRepository.save(aStudent.toStudent());
        return CreateStudentResponse.of(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentResponse> getStudent(final String anId) {
        return Optional.ofNullable(studentRepository.findById(anId)
                .map(StudentResponse::fromStudent)
                .orElseThrow(IllegalStateException::new));
    }

    public UpdateStudentResponse updateStudent(final String anId, final UpdateStudentRequest aStudent) {

        final var student = this.studentRepository
                .findById(anId).map(aStudent::toStudent)
                .orElseThrow(IllegalStateException::new);

        return UpdateStudentResponse.of(this.studentRepository.save(student));
    }

    public void deleteStudent(final String anId) {
        final var aStudent = studentRepository.findById(anId);
        aStudent.ifPresent(studentRepository::delete);
    }
}
