package com.example.professorservice.Services;

import com.example.professorservice.Dto.ProfessorDtoInput;
import com.example.professorservice.Dto.ProfessorDtoOutput;

public interface ProfessorService {
    ProfessorDtoOutput addProfessor(ProfessorDtoInput professorDtoInput);
    ProfessorDtoOutput updateProfessor(Long id, ProfessorDtoInput professor);
    void deleteStudent(Long id);

}
