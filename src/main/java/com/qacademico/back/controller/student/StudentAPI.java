package com.qacademico.back.controller.student;

import com.qacademico.back.controller.student.request.CreateStudentRequest;
import com.qacademico.back.controller.student.request.StudentRequest;
import com.qacademico.back.controller.student.request.UpdateStudentRequest;
import com.qacademico.back.controller.student.response.CreateStudentResponse;
import com.qacademico.back.controller.student.response.StudentResponse;
import com.qacademico.back.controller.student.response.UpdateStudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/students")
@Tag(name = "Students")
public interface StudentAPI {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422", description = "Unprocessable error"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    CreateStudentResponse createStudent(@RequestBody CreateStudentRequest input);


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Get all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    List<StudentResponse> getAllStudents();


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "{id}"
    )
    @Operation(summary = "Get a student by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Student was not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    StudentResponse getById(@PathVariable(name = "id") String id);

    @PutMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Update a student by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student Update successfully"),
            @ApiResponse(responseCode = "404", description = "Student was not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    UpdateStudentResponse updateById(@PathVariable(name = "id") String id, @RequestBody UpdateStudentRequest input);

    @DeleteMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a student by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student was not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    void deleteById(@PathVariable(name = "id") String id);


}
