package com.qacademico.back.controller.subject.response;

import com.qacademico.back.model.Subject;
import lombok.Getter;

public record CreateSubjectResponse(String id) {

    public static CreateSubjectResponse of(final Subject subject) {
        return new CreateSubjectResponse(subject.getId());
    }

}
