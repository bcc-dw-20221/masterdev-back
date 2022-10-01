package com.qacademico.back.controller.course;

import com.qacademico.back.controller.course.request.CreateCourseRequest;
import com.qacademico.back.controller.course.request.UpdateCourseRequest;
import com.qacademico.back.controller.course.response.CourseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/courses")
@Tag(name = "Course")
public interface CourseAPI {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422", description = "Unprocessable error"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    CreateCourseResponse createCourse(@RequestBody CreateCourseRequest input);


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Get all courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "course retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    List<CourseResponse> getAllCourses();


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "{id}"
    )
    @Operation(summary = "Get a course by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Courses retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Course was not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    CourseResponse getCourseById(@PathVariable(name = "id") String id);


    @PutMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Update a course by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course Update successfully"),
            @ApiResponse(responseCode = "404", description = "Course was not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    UpdateCourseResponse updateCourseById(@PathVariable(name = "id") String id, @RequestBody UpdateCourseRequest input);

    @DeleteMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a course by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Course deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Course was not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    void deleteCourseById(@PathVariable(name = "id") String id);
}
