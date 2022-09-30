package com.qacademico.back.controller.student.response;

import com.qacademico.back.model.Student;

public record CreateStudentResponse(
        String id
) {

    public static CreateStudentResponse of(final Student aStudent) {
        return new CreateStudentResponse(aStudent.getId());
    }
}
