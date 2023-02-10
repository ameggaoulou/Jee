package com.example.studentservice.Service;

import com.example.studentservice.Dto.StudentDtoInput;
import com.example.studentservice.Dto.StudentDtoOutput;

public interface StudentService {
    StudentDtoOutput addStudent(StudentDtoInput studentDtoInput);
    StudentDtoOutput updateStudent(Long id, StudentDtoInput student);
    void deleteStudent(Long id);
    int ShowNbrAbsenceByName(String name);
    int ShowNbrAbsenceById(Long id);
}
