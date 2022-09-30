package com.qacademico.back.services.professor;

import com.qacademico.back.controller.professor.request.UpdateProfessorRequest;
import com.qacademico.back.controller.professor.response.GetProfessorResponse;
import com.qacademico.back.controller.professor.response.UpdateProfessorResponse;
import com.qacademico.back.controller.student.response.UpdateStudentResponse;
import com.qacademico.back.model.Professor;
import com.qacademico.back.model.Subject;
import com.qacademico.back.repository.ProfessorRepository;
import com.qacademico.back.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Professor create(Professor professor){
//        Set<Subject> auxList = new HashSet<>();
//
//        for (int i = 0; i < professor.getSubjects().size(); i++){
//            Subject subject = professor.getSubjects().get(i);
//            String subjectName = subject.getName();
//            Subject subjectInRepo = subjectRepository.findByName(subjectName);
//
//            if (subjectInRepo != null){
//                auxList.add(subjectInRepo);
//            } else {
//                auxList.add(subject);
//                subjectRepository.save(subject);
//            }
//        }
//        professor.getSubjects().clear();
//        professor.getSubjects().addAll(auxList);
        return professorRepository.save(professor);
    }

    public List<GetProfessorResponse> findAllProfessors(){
        return professorRepository.findAll().stream().map(GetProfessorResponse::of).toList();
    }

    public Optional<GetProfessorResponse> findProfessorById(String id){
        return Optional.ofNullable(professorRepository.findById(id)
                .map(GetProfessorResponse::of)
                .orElseThrow(IllegalStateException::new));
    }

    public UpdateProfessorResponse updateProfessor(final UpdateProfessorRequest aProfessor, final String id){

        final var professor = this.professorRepository
                .findById(id).map(aProfessor::toProfessor)
                .orElseThrow(IllegalStateException::new);

        return UpdateProfessorResponse.of(this.professorRepository.save(professor));

//        var professorByEmail = professorRepository.findByEmail(professor.getEmail());

//        if(professorByEmail != null && !professorByEmail.getId().equals(id)){
//            throw new RuntimeException("Email already in use!");
//        }

//        Set<Subject> auxList = new HashSet<>();
//
//        for (int i = 0; i<repoProfessor.get().getSubjects().size(); i++){
//
//            Subject subject = professor.getSubjects().get(i);
//            String subjectName = subject.getName();
//            Subject subjectInRepo = subjectRepository.findByName(subjectName);
//
//            if (subjectInRepo != null) {
//                auxList.add(subjectInRepo);
//            } else {
//                auxList.add(subject);
//                subjectRepository.save(subject);
//            }
//        }
//
//        repoProfessor.get().getSubjects().clear();
//        repoProfessor.get().getSubjects().addAll(auxList);
//
//        repoProfessor.get().setName(professor.getName());
//        repoProfessor.get().setCpf(professor.getCpf());
//        repoProfessor.get().setAddress(professor.getAddress());
//        repoProfessor.get().setEmail(professor.getEmail());
//        repoProfessor.get().setPhone(professor.getPhone());
//        repoProfessor.get().setBirthDate(professor.getBirthDate());

    }

//    public Professor addSubjectToProfessor(UUID profId, UUID subjId){
//        var repoSubject = subjectRepository.findById(subjId);
//        var repoProfessor = professorRepository.findById(profId);
//
//        if (repoProfessor.isEmpty())
//            throw new RuntimeException("Professor not found.");
//        else if (repoSubject.isEmpty())
//            throw new RuntimeException("Subject not found.");
//        else if (repoProfessor.get().getSubjects().contains(repoSubject))
//            throw new RuntimeException("Professor already has subject.");
//
//        repoProfessor.get().getSubjects().add(repoSubject.get());
//
//        return professorRepository.save(repoProfessor.get());
//    }
    public void deleteProfessorById(final String id){
        final var professor = this.professorRepository.findById(id);
        if(professor.isPresent()) {
            professorRepository.deleteById(id);
        }
    }

}
