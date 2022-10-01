package com.qacademico.back.controller.course;

import com.qacademico.back.controller.course.request.CreateCourseRequest;
import com.qacademico.back.controller.course.request.UpdateCourseRequest;
import com.qacademico.back.controller.course.response.CourseResponse;
import com.qacademico.back.services.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class CourseController implements CourseAPI{

    @Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = Objects.requireNonNull(courseService);
    }

    @Override
    public CreateCourseResponse createCourse(CreateCourseRequest input) {
        return this.courseService.createCourse(input);
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return this.courseService.findAllCourses()
                .stream().map(CourseResponse::fromCourse)
                .toList();
    }

    @Override
    public CourseResponse getCourseById(String id) {
        return courseService.findCourseById(id).get();
    }

    @Override
    public UpdateCourseResponse updateCourseById(String id, UpdateCourseRequest input) {
        return this.courseService.updateCourseById(id, input);
    }

    @Override
    public void deleteCourseById(String id) {
        this.courseService.deleteCourseById(id);
    }
}
