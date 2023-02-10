package com.example.studentservice.Service;

import com.example.studentservice.Dto.GrpDtoInput;
import com.example.studentservice.Dto.GrpDtoOutput;
import com.example.studentservice.Entitie.Student;

import java.util.List;

public interface GrpService {
    GrpDtoOutput addGrp(GrpDtoInput grpDtoInput);
    GrpDtoOutput updateGrp(Long id, GrpDtoInput grp);

    void deleteGrp(Long id);
    void addStudentToGrp(List<Student> ListS, Long grpId);

}
