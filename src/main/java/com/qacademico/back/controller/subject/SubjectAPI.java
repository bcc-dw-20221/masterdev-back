package com.qacademico.back.controller.subject;

import com.qacademico.back.controller.student.request.CreateStudentRequest;
import com.qacademico.back.controller.student.request.UpdateStudentRequest;
import com.qacademico.back.controller.student.response.CreateStudentResponse;
import com.qacademico.back.controller.student.response.StudentResponse;
import com.qacademico.back.controller.student.response.UpdateStudentResponse;
import com.qacademico.back.controller.subject.request.CreateSubjectRequest;
import com.qacademico.back.controller.subject.request.UpdateSubjectRequest;
import com.qacademico.back.controller.subject.response.CreateSubjectResponse;
import com.qacademico.back.controller.subject.response.GetSubjectResponse;
import com.qacademico.back.controller.subject.response.UpdateSubjectResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/subjects")
@Tag(name = "Subject")
public interface SubjectAPI {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new subject")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422", description = "Unprocessable error"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    CreateSubjectResponse createSubject(@RequestBody CreateSubjectRequest input);


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Get all subjects")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subjects retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    List<GetSubjectResponse> getAllSubjects();


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "{id}"
    )
    @Operation(summary = "Get a subject by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Subject retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Subject was not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    GetSubjectResponse getById(@PathVariable(name = "id") String id);

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
    UpdateSubjectResponse updateById(@PathVariable(name = "id") String id, @RequestBody UpdateSubjectRequest input);

    @DeleteMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a subject by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Subject deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Subject was not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    void deleteById(@PathVariable(name = "id") String id);


}
