package com.example.studentservice;


import com.example.studentservice.Entitie.Grp;
import com.example.studentservice.Entitie.Student;
import com.example.studentservice.Enum.Gender;
import com.example.studentservice.Repository.GrpRepository;
import com.example.studentservice.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class StudentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, GrpRepository grpRepository,
                                        RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Student.class);
            for(int i=1; i<=4; i++){
                Grp grp = Grp.builder()
                        .name("IIRG"+i)
                        .build();
                grpRepository.save(grp);

                for(int j=1; j<=10; j++){
                    Student student = Student.builder()
                            .fullName("Etud "+j)
                            .birthDate(new Date())
                            .NID("CIN_ "+j)
                            .gender((j%2 == 0) ? Gender.FEMALE : Gender.MALE)
                            .contactNo("066100000"+j)
                            .address("Adresse Etudiant "+j)
                            .enabled((j%2 == 0) ? Boolean.FALSE : Boolean.TRUE)
                            .grp(grp)
                            .build();
                    studentRepository.save(student);
                }
            }
        };
    }
}


