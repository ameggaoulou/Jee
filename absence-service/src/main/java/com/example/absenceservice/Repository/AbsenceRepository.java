package com.example.absenceservice.Repository;

import com.example.absenceservice.Entitie.Absence;
import com.example.absenceservice.Model.Course;
import com.example.absenceservice.Model.Professor;
import com.example.absenceservice.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AbsenceRepository extends JpaRepository<Absence,Long> {
    List<Absence> findAllByStudentId(Long studentId);
    List<Absence> findAllByCourseId(Long  courseId);
    List<Absence> findAllByProfessorId(Long  professorId);

}
