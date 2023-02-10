package com.example.studentservice.Mapper;

import com.example.studentservice.Dto.StudentDtoOutput;
import com.example.studentservice.Entitie.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDtoOutput fromStudent(Student student){
        StudentDtoOutput studentDtoOutput = new StudentDtoOutput();
        BeanUtils.copyProperties(student,studentDtoOutput);
        return studentDtoOutput;
    }
}
