package com.example.courseservice;

import com.example.courseservice.Entitie.Course;
import com.example.courseservice.Repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class CourseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CourseRepository courseRepository,
                                        RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Course.class);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date d1 = dateFormat.parse("2019-11-5 08:30");
            Date d2 = dateFormat.parse("2020-1-5 10:30");
            Random random = new Random();

            for(int i = 1; i<=10; i++){
                Long grpId = random.nextLong(3) + 1;
                Long professorId = random.nextLong(10) + 1;
                Course course = Course.builder()
                        .name("name"+i)
                        .description("course"+i)
                        .StartDate(d1)
                        .EndDate(d2)
                        .NbrSeance(24+i)
                        .grpId(Long.valueOf(grpId))
                        .professorId(Long.valueOf(professorId))
                        .build();
                courseRepository.save(course);
            }
        };
    }




}
