package com.example.absenceservice.Mapper;

import com.example.absenceservice.Dto.AbsenceDtoOutput;
import com.example.absenceservice.Entitie.Absence;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AbsenceMapper {
    public AbsenceDtoOutput fromAbsence(Absence absence){
        AbsenceDtoOutput absenceDtoOutput = new AbsenceDtoOutput();
        BeanUtils.copyProperties(absence,absenceDtoOutput);
        return absenceDtoOutput;
    }
}
