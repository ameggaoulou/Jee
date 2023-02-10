package com.example.professorservice.Repository;

import com.example.professorservice.Entitie.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
}
