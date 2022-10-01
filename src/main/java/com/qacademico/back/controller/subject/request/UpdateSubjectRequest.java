package com.qacademico.back.controller.subject.request;

import com.qacademico.back.model.Subject;
import lombok.Setter;

import java.util.UUID;

public record UpdateSubjectRequest(String name, String timeSpan, String professorList) {

    public Subject toSubject() {

        final var subject = new Subject();
        subject.setName(name);
        subject.setTimeSpan(timeSpan);
        subject.setProfessors(professorList);

        return subject;
    }
}
