package com.example.professorservice.Services;

import com.example.professorservice.Dto.ProfessorDtoInput;
import com.example.professorservice.Dto.ProfessorDtoOutput;
import com.example.professorservice.Entitie.Professor;
import com.example.professorservice.Mapper.ProfessorMapper;
import com.example.professorservice.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;
    @Autowired
    ProfessorMapper professorMapper;
    @Override
    public ProfessorDtoOutput addProfessor(ProfessorDtoInput professorDtoInput) {
        Professor professor = new Professor();
        professor.setFullName(professorDtoInput.getFullName());
        professor.setGender(professorDtoInput.getGender());
        professor.setAddress(professorDtoInput.getAddress());
        professor.setNID(professorDtoInput.getNID());
        professor.setContactNo(professorDtoInput.getContactNo());
        professor.setEnabled(Boolean.TRUE);
        Professor savedProfessor = professorRepository.save(professor);
        ProfessorDtoOutput professorDtoOutput = professorMapper.fromProfessor(savedProfessor);
        return professorDtoOutput;
    }

    @Override
    public ProfessorDtoOutput updateProfessor(Long id, ProfessorDtoInput professor) {
        Professor professorById =  professorRepository.findById(id).get();
        if(professorById != null){
            professorById.setFullName(professor.getFullName());
            professorById.setAddress(professor.getAddress());
            professorById.setGender(professor.getGender());
            professorById.setNID(professor.getNID());
            professorById.setContactNo(professor.getContactNo());
            return professorMapper.fromProfessor(professorById);
        }
        return null;
    }


    @Override
    public void deleteStudent(Long id) {
        professorRepository.deleteById(id);

    }
}
