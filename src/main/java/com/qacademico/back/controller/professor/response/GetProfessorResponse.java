package com.qacademico.back.controller.professor.response;

import com.qacademico.back.model.Professor;
import com.qacademico.back.model.Subject;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record GetProfessorResponse(
        String id,
        String name,
        String email,
        String address,
        String phone,
        LocalDate birthDate,
        String subjectNamesList
){
    public static GetProfessorResponse of(final Professor professor) {

        return new GetProfessorResponse(
                professor.getId(),
                professor.getName(),
                professor.getEmail(),
                professor.getAddress(),
                professor.getPhone(),
                professor.getBirthDate(),
                professor.getSubjects()
        );
    }
}
