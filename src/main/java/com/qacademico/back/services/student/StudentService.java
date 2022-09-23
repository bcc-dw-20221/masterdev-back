package com.qacademico.back.services.student;


import com.qacademico.back.model.Student;
import com.qacademico.back.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student aStudent) {

        if (aStudent.getId() == null) {
            final var andId = UUID.randomUUID();
            aStudent.setId(andId.toString());
        }

        return this.studentRepository.save(aStudent);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentes(final String anId) {
        return studentRepository.findById(anId);
    }

    public Student updateStudent(final Student anStudent) {
        return studentRepository.save(anStudent);
    }

    public void deleteStudent(final String anId) {
        final var aStudent = studentRepository.findById(anId)
                .orElse(null);
        if (aStudent != null) {
            studentRepository.delete(aStudent);
        }
    }
}
