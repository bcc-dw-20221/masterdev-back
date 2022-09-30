package com.qacademico.back.controller.professor;

import com.qacademico.back.controller.professor.request.CreateProfessorRequest;
import com.qacademico.back.controller.professor.request.UpdateProfessorRequest;
import com.qacademico.back.controller.professor.response.CreateProfessorResponse;
import com.qacademico.back.controller.professor.response.GetProfessorResponse;
import com.qacademico.back.controller.professor.response.UpdateProfessorResponse;
import com.qacademico.back.controller.student.request.CreateStudentRequest;
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

@RequestMapping(value = "/api/professor")
@Tag(name = "Professor")
public interface ProfessorAPI {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "422", description = "Unprocessable error"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    CreateProfessorResponse createProfessor(@RequestBody CreateProfessorRequest input);


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Get all professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professor retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    List<GetProfessorResponse> getAllProfessor();


    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "{id}"
    )
    @Operation(summary = "Get a professor by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professor retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Professor was not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    GetProfessorResponse getById(@PathVariable(name = "id") String id);

    @PutMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Update a professor by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Professor Update successfully"),
            @ApiResponse(responseCode = "404", description = "Professor was not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    UpdateProfessorResponse updateById(@PathVariable(name = "id") String id, @RequestBody UpdateProfessorRequest input);

    @DeleteMapping(
            value = "{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a professor by it's identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Professor deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Professor was not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error"),
    })
    void deleteById(@PathVariable(name = "id") String id);


}
