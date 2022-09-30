package com.qacademico.back.controller.subject.request;

import com.qacademico.back.model.Professor;
import com.qacademico.back.model.Subject;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class SubjectRequest {
    private String name;
    private String timeSpan;
    private List<Professor> professorList = new ArrayList<>();

    public Subject toSubject(){
        final var subject = new Subject();

        subject.setName(name);
        subject.setTimeSpan(timeSpan);

        return subject;
    }

}
