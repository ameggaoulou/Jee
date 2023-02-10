package com.example.studentservice.Service;

import com.example.studentservice.Dto.GrpDtoInput;
import com.example.studentservice.Dto.GrpDtoOutput;
import com.example.studentservice.Entitie.Grp;
import com.example.studentservice.Entitie.Student;
import com.example.studentservice.Mapper.GrpMapper;
import com.example.studentservice.Repository.GrpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class GrpServiceImpl implements GrpService{

    @Autowired
    GrpRepository grpRepository;
    @Autowired
    GrpMapper grpMapper;
    @Override
    public GrpDtoOutput addGrp(GrpDtoInput grpDtoInput) {
        Grp grp = new Grp();
        grp.setName(grpDtoInput.getName());
        grp.setStudents(grpDtoInput.getStudents());


        Grp savedGrp = grpRepository.save(grp);

        GrpDtoOutput grpDtoOutput = grpMapper.fromGrp(savedGrp);
        return grpDtoOutput;
    }

    @Override
    public GrpDtoOutput updateGrp(Long id, GrpDtoInput grp) {
        Grp grpById =  grpRepository.findById(id).get();
        if(grpById != null){
            grp.setName(grp.getName());
            grp.setStudents(grp.getStudents());

            return grpMapper.fromGrp(grpById);
        }
        return null;
    }

    @Override
    public void deleteGrp(Long id) {
        grpRepository.deleteById(id);
    }

    @Override
    public void addStudentToGrp(List<Student> students, Long grpId) {
        Grp grp = grpRepository.findById(grpId).orElse(null);
        if (grp != null) {
            for (Student student : students) {
                grp.getStudents().add(student);
            }
            grpRepository.save(grp);
        }
    }




}

