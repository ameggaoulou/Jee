package com.example.absenceservice;

import com.example.absenceservice.Entitie.Absence;
import com.example.absenceservice.Model.Course;
import com.example.absenceservice.Model.Professor;
import com.example.absenceservice.Model.Student;
import com.example.absenceservice.Repository.AbsenceRepository;
import com.example.absenceservice.Service.ProfessorRestClient;
import com.example.absenceservice.Service.StudentRestClient;
import com.example.absenceservice.Service.CourseRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class AbsenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AbsenceServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(AbsenceRepository absenceRepository,
                            CourseRestClient courseRestClient,
                            StudentRestClient studentRestClient,
                            ProfessorRestClient professorRestClient){
        return args -> {
            Random random = new Random();
            for(int i = 1; i<=10; i++){
                Long stId = random.nextLong(40) + 1;
                Long crsId = random.nextLong(10) + 1;
                Long prId = random.nextLong(10) + 1;
                LocalDate d1=LocalDate.now();
                Student student = studentRestClient.findStudentById(stId.longValue());
                Course cour = courseRestClient.findCourseById(crsId.longValue());
                Professor professor=professorRestClient.findProfessorById(prId.longValue());
                Absence absence = Absence.builder()
                        .studentId(stId)
                        .student(student)
                        .course(cour)
                        .courseId(crsId)
                        .professor(professor)
                        .professorId(prId)
                        .absenceDate(d1)
                        .build();
                absenceRepository.save(absence);
            }
        };
    }

}
