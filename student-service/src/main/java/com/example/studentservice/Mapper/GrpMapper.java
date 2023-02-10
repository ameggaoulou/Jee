package com.example.studentservice.Mapper;

import com.example.studentservice.Dto.GrpDtoOutput;
import com.example.studentservice.Dto.StudentDtoOutput;
import com.example.studentservice.Entitie.Grp;
import com.example.studentservice.Entitie.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class GrpMapper {
    public GrpDtoOutput fromGrp(Grp Grp){
        GrpDtoOutput grpDtoOutput = new GrpDtoOutput();
        BeanUtils.copyProperties(Grp,grpDtoOutput);
        return grpDtoOutput;
    }
}
