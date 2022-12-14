package com.qacademico.back.services.subject;

import com.qacademico.back.controller.subject.request.UpdateSubjectRequest;
import com.qacademico.back.controller.subject.response.GetSubjectResponse;
import com.qacademico.back.controller.subject.response.UpdateSubjectResponse;
import com.qacademico.back.model.Subject;
import com.qacademico.back.repository.ProfessorRepository;
import com.qacademico.back.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public SubjectService() {
    }

    public Subject createSubject(Subject subject) {
//        Set<Professor> auxList = new HashSet<>();
//
//        for (int i = 0; i < subject.getProfessors().size(); i++){
//            Professor professor = subject.getProfessors().get(i);
//            String professorEmail = professor.getEmail();
//            var professorInRepo = professorRepository.findByEmail(professorEmail);
//
//            if (professorInRepo != null){
//                auxList.add(professorInRepo);
//            } else {
//                auxList.add(professor);
//            }
//        }
//
//        subject.getProfessors().clear();
//        subject.getProfessors().addAll(auxList);

        return subjectRepository.save(subject);
    }

    public List<GetSubjectResponse> findSubjects() {
        return subjectRepository.findAll().stream().map(GetSubjectResponse::of).toList();
    }

    public Optional<GetSubjectResponse> findSubjecById(String id) {
        return subjectRepository.findById(id).map(GetSubjectResponse::of);
    }

    //TODO: Update não atualiza a lista de subjects em professor.
    public UpdateSubjectResponse updadeSubject(UpdateSubjectRequest aSubject, String id) {
        final var subject = subjectRepository.findById(id).orElseThrow(IllegalStateException::new);

        return UpdateSubjectResponse.of(this.subjectRepository.save(subject));

//        var subjectByName = subjectRepository.findByName(subject.getName());
//
//        if(subjectByName != null && !subjectByName.getId().equals(id)){
//            throw new RuntimeException("Subject already exists!");
//        }
//
//        Set<Professor> auxList = new HashSet<>();
//
//        for (int i = 0; i < subject.getProfessors().size(); i++) {
//            Professor professor = subject.getProfessors().get(i);
//            String professorEmail = professor.getEmail();
//            var professorInRepo = professorRepository.findByEmail(professorEmail);
//
//            if (professorInRepo != null) {
//                auxList.add(professorInRepo);
//            } else {
//                auxList.add(professor);
//            }
//        }
//
//        repoSubject.get().getProfessors().clear();
//        repoSubject.get().getProfessors().addAll(auxList);
//
//        repoSubject.get().setName(subject.getName());
//        repoSubject.get().setTimeSpan(subject.getTimeSpan());

    }

//    public void deleteSubjectById(UUID id){
//        subjectRepository.deleteById(id);
//    }
//
//    //TODO: addProfessorToSubject não atualiza a lista de subjects em professor.
//    public Subject addProfessorToSubject(UUID subjId, UUID profId){
//        var repoSubject = subjectRepository.findById(subjId);
//        var repoProfessor = professorRepository.findById(profId);
//
//        if (repoProfessor.isEmpty())
//            throw new RuntimeException("Professor not found.");
//        else if (repoSubject.isEmpty())
//            throw new RuntimeException("Subject not found.");
//        else if (repoSubject.get().getProfessors().contains(repoProfessor))
//            throw new RuntimeException("Subject already has professor.");
//
//        repoSubject.get().getProfessors().add(repoProfessor.get());
//
//        return subjectRepository.save(repoSubject.get());
//    }

    public void deleteSubject(final String anId) {
        final var subject = subjectRepository.findById(anId);
        subject.ifPresent(subjectRepository::delete);
    }
}
