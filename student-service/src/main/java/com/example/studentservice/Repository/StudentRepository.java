package com.example.studentservice.Repository;

import com.example.studentservice.Entitie.Grp;
import com.example.studentservice.Entitie.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource

public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByFullNameContains(String fullname);
    List<Student> findAllByGrp(Grp grp);
}
