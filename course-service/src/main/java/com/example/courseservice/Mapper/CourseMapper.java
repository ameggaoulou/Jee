package com.example.courseservice.Mapper;

import com.example.courseservice.Dto.CourseDtoOutput;
import com.example.courseservice.Entitie.Course;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseDtoOutput fromCourse(Course course){
        CourseDtoOutput courseDtoOutput = new CourseDtoOutput();
        BeanUtils.copyProperties(course,courseDtoOutput);
        return courseDtoOutput;
    }

}
