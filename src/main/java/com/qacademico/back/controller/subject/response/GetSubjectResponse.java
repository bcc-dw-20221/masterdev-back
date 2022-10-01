package com.qacademico.back.controller.subject.response;

import com.qacademico.back.model.Subject;
import lombok.Getter;

public record GetSubjectResponse(

        String id,
        String name,
        String timeSpan,
        String professorList

) {

    public static GetSubjectResponse of(final Subject subject) {
        return new GetSubjectResponse(subject.getId(), subject.getName(), subject.getTimeSpan(), subject.getProfessors());
    }

}
