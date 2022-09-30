package com.qacademico.back.controller.professor.response;

import com.qacademico.back.model.Professor;
import lombok.Getter;

public record UpdateProfessorResponse(

) {
    public static UpdateProfessorResponse of(final Professor professor) {
        return new UpdateProfessorResponse();
    }
}
