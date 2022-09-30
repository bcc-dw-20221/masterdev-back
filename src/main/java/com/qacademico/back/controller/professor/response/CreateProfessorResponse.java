package com.qacademico.back.controller.professor.response;

import com.qacademico.back.model.Professor;
import com.qacademico.back.model.Subject;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


public record CreateProfessorResponse(
        String id
) {
    public static CreateProfessorResponse of(final Professor professor) {
        return new CreateProfessorResponse(professor.getId());
    }
}
