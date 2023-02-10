package com.example.studentservice.Repository;

import com.example.studentservice.Entitie.Grp;
import com.example.studentservice.Entitie.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GrpRepository extends JpaRepository<Grp,Long> {

}
