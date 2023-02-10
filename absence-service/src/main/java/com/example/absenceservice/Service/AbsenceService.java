package com.example.absenceservice.Service;

import com.example.absenceservice.Dto.AbsenceDtoInput;
import com.example.absenceservice.Dto.AbsenceDtoOutput;
import com.example.absenceservice.Entitie.Absence;
import com.example.absenceservice.Model.Course;
import com.example.absenceservice.Model.Professor;
import com.example.absenceservice.Model.Student;

import java.util.List;

public interface AbsenceService {
    AbsenceDtoOutput addAbsence(AbsenceDtoInput absenceDtoInput);
    void deleteAbsence(Long id);
    List<Absence> findAllByStudent(Long studentId);
    List<Absence> findAllByCourse(Long courseId);
    List<Absence> findAllByProfessor(Long professorId);


}
