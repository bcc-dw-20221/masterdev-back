package com.qacademico.back.controller.course.response;
import com.qacademico.back.model.Course;

public record CreateCourseResponse (String id){

    public static createCourseResponse of(final Course course){
        return new CreateCourseResponse(course.getId());
        }
}
