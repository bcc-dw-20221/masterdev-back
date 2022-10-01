package com.qacademico.back.controller.course.response;
import com.qacademico.back.model.Course;

import lombok.Getter;

@Getter
public class CourseResponse {
    private String id;
    private String name;
    private String timeSpan;
    private String student;

    private CourseResponse(String id, String name, String timeSpan, String student) {
        this.id = id;
        this.name = name;
        this.timeSpan = timeSpan;
        this.student = student;
    }

    public static CourseResponse fromCourse(final Course course) {
        return new CourseResponse(
                course.getId(),
                course.getName(),
                course.getTimeSpan(),
                course.getStudent()
        );
    }
}
