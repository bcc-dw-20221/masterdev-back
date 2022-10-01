package com.qacademico.back.controller.course.response;
import com.qacademico.back.model.Course;

public record UpdateCourseResponse(){
    public static UpdateCourseResponse of(final Course course){
        return new UpdateStudentResponse();
        }
}
