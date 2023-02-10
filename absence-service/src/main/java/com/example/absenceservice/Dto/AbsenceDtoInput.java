package com.example.absenceservice.Dto;

import com.example.absenceservice.Model.Course;
import com.example.absenceservice.Model.Professor;
import com.example.absenceservice.Model.Student;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceDtoInput {
    private Long id;
    private Long studentId;
    private Long professorId;
    private Long courseId;
    private Boolean justified;
    private LocalDate absenceDate;

}
