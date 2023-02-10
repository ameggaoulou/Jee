package com.example.absenceservice.Service;

import com.example.absenceservice.Model.Professor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PROFESSOR-SERVICE")
public interface ProfessorRestClient {
    @GetMapping(path="/professors/{id}")
    Professor findProfessorById(@PathVariable Long id);
}
