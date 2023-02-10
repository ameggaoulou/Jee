package com.example.absenceservice.Service;

import com.example.absenceservice.Model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "STUDENT-SERVICE")
public interface StudentRestClient {
    @GetMapping(path="/students/{id}")
    Student findStudentById(@PathVariable Long id);
}
