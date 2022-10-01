package com.qacademico.back.services.course;

import com.qacademico.back.controller.course.request.CreateCourseRequest;
import com.qacademico.back.controller.course.request.UpdateCourseRequest;
import com.qacademico.back.controller.course.response.CourseResponse;
import com.qacademico.back.model.Course;
import com.qacademico.back.repository.CourseRepository;
import com.qacademico.back.controller.course.response.CreateCourseResponse;
import com.qacademico.back.controller.course.response.UpdateCourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CreateCourseResponse createCourse(final CreateCourseRequest createCourseRequest){
        final var course = this.courseRepository.save(createCourseRequest.toCourse());

        return CreateCourseResponse.of(course);
    }

    public UpdateCourseResponse updateCourseById(final String id, final UpdateCourseRequest updateCourseRequest){
        var course = this.courseRepository.findById(id)
                .map(updateCourseRequest::toCourse)
                .orElseThrow(IllegalStateException::new);

        return UpdateCourseResponse.of(this.courseRepository.save(course));
    }

    public List<Course> findAllCourses(){
        return courseRepository.findAll();
    }

    public Optional<CourseResponse> findCourseById(final String id){
        return Optional.ofNullable(courseRepository.findById(id)
                .map(CourseResponse::fromCourse)
                .orElseThrow(IllegalStateException::new));
    }

    public void deleteCourseById(final String id){
        var course = courseRepository.findById(id);
        course.ifPresent(courseRepository::delete);
    }

}
