
package com.qacademico.back.controller.course.request;

import com.qacademico.back.model.Course;
import lombok.Setter;

import java.util.HashSet;
import java.util.UUID;

@Setter
public class UpdateCourseRequest {

    private String name;
    private String timeSpan;
    private String student;

    public Course toCourse(final Course course){

        course.setName(name);
        course.setTimeSpan(timeSpan);
        course.setStudent(student);

        return course;
    }


}

