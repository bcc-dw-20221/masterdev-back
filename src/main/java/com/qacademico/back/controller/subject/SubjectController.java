package com.qacademico.back.controller.subject;

import com.qacademico.back.controller.subject.request.CreateSubjectRequest;
import com.qacademico.back.controller.subject.request.UpdateSubjectRequest;
import com.qacademico.back.controller.subject.response.CreateSubjectResponse;
import com.qacademico.back.controller.subject.response.GetSubjectResponse;
import com.qacademico.back.controller.subject.response.UpdateSubjectResponse;
import com.qacademico.back.services.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectController implements SubjectAPI {

    @Autowired
    private SubjectService subjectService;

    @Override
    public CreateSubjectResponse createSubject(CreateSubjectRequest input) {
        final var subject = this.subjectService.createSubject(input.toSubject());

        return CreateSubjectResponse.of(subject);
    }

    @Override
    public List<GetSubjectResponse> getAllSubjects() {
        return this.subjectService.findSubjects();
    }

    @Override
    public GetSubjectResponse getById(String id) {
        final var subject = this.subjectService.findSubjecById(id);
        return subject.orElse(null);
    }

    @Override
    public UpdateSubjectResponse updateById(String id, UpdateSubjectRequest input) {
        return this.subjectService.updadeSubject(input, id);
    }

    @Override
    public void deleteById(String id) {

        this.subjectService.deleteSubject(id);

    }
}
