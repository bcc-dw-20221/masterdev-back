package com.qacademico.back.repository;

import com.qacademico.back.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
    boolean existsByEmail(String email);
    Professor findByEmail(String email);
}
