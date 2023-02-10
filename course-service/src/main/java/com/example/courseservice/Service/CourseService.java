package com.example.courseservice.Service;

import com.example.courseservice.Dto.CourseDtoInput;
import com.example.courseservice.Dto.CourseDtoOutput;
import com.example.courseservice.Entitie.Course;

import java.util.List;

public interface CourseService {
    CourseDtoOutput addCourse(CourseDtoInput courseDtoInput);
    CourseDtoOutput updateCourse(Long id, CourseDtoInput course);
    void deleteCourse(Long id);
    List<Course> courseByGrp(Long GrpId);
    List<Course> courseByProfessorId(Long ProfessorId);
}
