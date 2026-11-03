package com.mari.cursos.repositories;

import com.mari.cursos.domain.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
