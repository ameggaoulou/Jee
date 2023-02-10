package com.example.professorservice.Mapper;

import com.example.professorservice.Dto.ProfessorDtoOutput;
import com.example.professorservice.Entitie.Professor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {
    public ProfessorDtoOutput fromProfessor(Professor professor){
        ProfessorDtoOutput professorDtoOutput = new ProfessorDtoOutput();
        BeanUtils.copyProperties(professor,professorDtoOutput);
        return professorDtoOutput;
    }
}
