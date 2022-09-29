package com.qacademico.back.controller.professor.request;

import com.qacademico.back.model.Professor;
import com.qacademico.back.model.Subject;
import lombok.Setter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
public class ProfessorRequest {
    private String name;
    private String email;
    private String cpf;
    private String address;
    private String phone;
    private LocalDate birthDate;
    private String password;

    private List<Subject>  subjectList = new ArrayList<Subject>();

    public Professor toProfessor() {

        final var professor = new Professor();

        professor.setName(name);
        professor.setCpf(cpf);
        professor.setPassword(password);
        professor.setEmail(email);
        professor.setPhone(phone);
        professor.setAddress(address);
        professor.setBirthDate(birthDate);
        professor.setSubjects(subjectList);

        return professor;
    }
}
