package com.qacademico.back.controller.professor.response;

import com.qacademico.back.model.Professor;
import com.qacademico.back.model.Subject;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class ProfessorResponse {

    private UUID id;
    private String name;
    private String email;
    private String address;
    private String phone;
    private LocalDate birthDate;
    private List<String> subjectNamesList = new ArrayList<String>();
    public ProfessorResponse fromProfessor(final Professor professor) {
        this.id = professor.getId();
        this.name = professor.getName();
        this.email = professor.getEmail();
        this.phone = professor.getPhone();
        this.address = professor.getAddress();
        this.birthDate = professor.getBirthDate();

        this.subjectNamesList = professor.getSubjects().stream()
        .map(Subject::getName)
        .collect(Collectors.toCollection(ArrayList::new));

        return this;
    }
}
