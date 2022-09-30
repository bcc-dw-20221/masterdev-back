package com.qacademico.back.controller.professor;

import com.qacademico.back.controller.professor.request.ProfessorRequest;
import com.qacademico.back.controller.professor.response.ProfessorResponse;
import com.qacademico.back.model.Professor;
import com.qacademico.back.services.professor.ProfessorService;
import com.qacademico.back.services.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/professors")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @Autowired
    private SubjectService subjectService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorResponse createProfessor(@RequestBody ProfessorRequest professorRequest){
        final var professor = professorService.create(professorRequest.toProfessor());
        return new ProfessorResponse().fromProfessor(professor);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> getAllProfessors(){
        return professorService.findAllProfessors();
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorResponse updateProfessorById(@RequestBody ProfessorRequest professorRequest, @PathVariable("id") UUID id){
        var professor = professorService.updateProfessor(professorRequest.toProfessor(), id);
        return new ProfessorResponse().fromProfessor(professor);
    }

    @PutMapping("/add-subject/{professorId}/{subjectId}")
    @ResponseStatus(HttpStatus.OK)
    public ProfessorResponse addSubjectToProfessor(@PathVariable("professorId") UUID professorId,
                                                   @PathVariable("subjectId") UUID subjectId){
        var professor = professorService.addSubjectToProfessor(professorId, subjectId);
        return new ProfessorResponse().fromProfessor(professor);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProfessorById(@PathVariable("id") UUID id){
        professorService.deleteProfessorById(id);
    }
}
