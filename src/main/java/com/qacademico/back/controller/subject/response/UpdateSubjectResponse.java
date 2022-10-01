package com.qacademico.back.controller.subject.response;

import com.qacademico.back.model.Subject;
import lombok.Getter;

public record UpdateSubjectResponse(String id) {

    public static UpdateSubjectResponse of(final Subject subject) {
        return new UpdateSubjectResponse(subject.getId());
    }

}
