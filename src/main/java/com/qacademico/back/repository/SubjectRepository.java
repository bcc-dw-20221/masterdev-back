package com.qacademico.back.repository;

import com.qacademico.back.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
    boolean existsByName(String name);
    Subject findByName(String name);
}
