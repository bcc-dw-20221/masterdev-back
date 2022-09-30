package com.qacademico.back.controller.professor;

import com.qacademico.back.controller.professor.request.CreateProfessorRequest;
import com.qacademico.back.controller.professor.request.UpdateProfessorRequest;
import com.qacademico.back.controller.professor.response.CreateProfessorResponse;
import com.qacademico.back.controller.professor.response.GetProfessorResponse;
import com.qacademico.back.controller.professor.response.UpdateProfessorResponse;
import com.qacademico.back.services.professor.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class ProfessorController implements ProfessorAPI {
    @Autowired
    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = Objects.requireNonNull(professorService);
    }

    public CreateProfessorResponse createProfessor(@RequestBody CreateProfessorRequest professorRequest) {
        final var professor = professorService.create(professorRequest.toProfessor());
        return CreateProfessorResponse.of(professor);
    }

    @Override
    public List<GetProfessorResponse> getAllProfessor() {
        return this.professorService.findAllProfessors();
    }

    @Override
    public GetProfessorResponse getById(String id) {
        final var professor = this.professorService.findProfessorById(id);
        return professor.orElse(null);
    }

    @Override
    public UpdateProfessorResponse updateById(String id, UpdateProfessorRequest input) {
        return this.professorService.updateProfessor(input, id);
    }

    @Override
    public void deleteById(String id) {
        this.professorService.deleteProfessorById(id);

    }

//    @PutMapping("/add-subject/{professorId}/{subjectId}")
//    @ResponseStatus(HttpStatus.OK)
//    public ProfessorResponse addSubjectToProfessor(@PathVariable("professorId") UUID professorId,
//                                                   @PathVariable("subjectId") UUID subjectId){
//        var professor = professorService.addSubjectToProfessor(professorId, subjectId);
//        return new ProfessorResponse().fromProfessor(professor);
//    }
}
