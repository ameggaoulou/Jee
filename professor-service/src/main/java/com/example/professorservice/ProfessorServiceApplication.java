package com.example.professorservice;

import com.example.professorservice.Entitie.Professor;
import com.example.professorservice.Enum.Gender;
import com.example.professorservice.Repository.ProfessorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ProfessorServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfessorServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProfessorRepository professorRepository,
                                        RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Professor.class);
            for(int i = 1; i<=10; i++){
                Professor professor = Professor.builder()
                        .id((long) i)
                        .fullName("prof "+i)
                        .NID("CIN_ "+i)
                        .gender((i%2 == 0) ? Gender.FEMALE : Gender.MALE)
                        .contactNo("066100000"+i)
                        .address("Adresse professeur "+i)
                        .enabled((i%2 == 0) ? Boolean.FALSE : Boolean.TRUE)
                        .build();
                professorRepository.save(professor);

            }};
}}
