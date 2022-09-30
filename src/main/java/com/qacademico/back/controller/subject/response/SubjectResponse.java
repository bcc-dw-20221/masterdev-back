//package com.qacademico.back.controller.subject.response;
//
//import com.qacademico.back.model.Professor;
//import com.qacademico.back.model.Subject;
//import lombok.Getter;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Getter
//public class SubjectResponse {
//
//    private UUID id;
//    private String name;
//    private String timeSpan;
//    private List<String> professorEmailList = new ArrayList<String>();
//
//    public SubjectResponse fromSubject(Subject subject){
//        this.id = subject.getId();
//        this.name = subject.getName();
//        this.timeSpan = subject.getTimeSpan();
//        this.professorEmailList = subject.getProfessors().stream()
//                .map(Professor::getEmail)
//                .collect(Collectors.toCollection(ArrayList::new));
//
//        return this;
//    }
//}
