package com.qacademico.back.controller.student.response;

import com.qacademico.back.model.Student;

public record UpdateStudentResponse() {

    public static UpdateStudentResponse of(final Student aStudent) {

        return new UpdateStudentResponse();

    }

}
