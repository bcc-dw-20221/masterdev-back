package com.qacademico.back.repository;

import com.qacademico.back.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, UUID> {
    boolean existsByName(String name);
    Subject findByName(String name);
}
