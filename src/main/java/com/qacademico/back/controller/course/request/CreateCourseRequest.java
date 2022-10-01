package com.qacademico.back.controller.course.request;

import com.qacademico.back.model.Course;
import lombok.Setter;

import java.util.HashSet;
import java.util.UUID;

@Setter
public class CreateCourseRequest {

    private String id; //= UUID.randomUUID().toString();
    private String name;
    private String timeSpan;
    private String student;

    public Course toCourse(){
        final var course = new Course();

        course.setId(UUID.randomUUID().toString());
        course.setName(name);
        course.setTimeSpan(timeSpan);
        course.setStudent(student);

        return course;
    }

}
