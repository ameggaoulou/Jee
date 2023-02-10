package com.example.courseservice.Repository;

import com.example.courseservice.Entitie.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findAllByProfessorId(Long ProfessorId);
    List<Course> findAllByGrpId(Long GrpId);

}
