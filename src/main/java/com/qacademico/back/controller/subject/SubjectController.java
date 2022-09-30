//package com.qacademico.back.controller.subject;
//
//import com.qacademico.back.controller.subject.request.SubjectRequest;
//import com.qacademico.back.controller.subject.response.SubjectResponse;
//import com.qacademico.back.model.Subject;
//import com.qacademico.back.services.subject.SubjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("api/subjects")
//public class SubjectController {
//
//    @Autowired
//    private SubjectService subjectService;
//
//    public SubjectController(){}
//
//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<Subject> getAllSubjects(){
//        return subjectService.findSubjects();
//    }
//
//    @PostMapping("/post")
//    @ResponseStatus(HttpStatus.OK)
//    public SubjectResponse createSubject(@RequestBody SubjectRequest subjectRequest){
//        final var subject = subjectService.createSubject(subjectRequest.toSubject());
//        return new SubjectResponse().fromSubject(subject);
//    }
//
//    @PutMapping("/update/{subjectId}")
//    @ResponseStatus(HttpStatus.OK)
//    public SubjectResponse updateSubject(@RequestBody SubjectRequest subjectRequest,
//                                         @PathVariable("subjectId") UUID subjectId){
//        final var subject = subjectService.updadeSubject(subjectRequest.toSubject(), subjectId);
//        return new SubjectResponse().fromSubject(subject);
//    }
//
//    a
//
//    @DeleteMapping("/delete/{subjectId}")
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteSubjectById(@PathVariable("subjectId") UUID subjectId){
//        subjectService.deleteSubjectById(subjectId);
//    }
//}
