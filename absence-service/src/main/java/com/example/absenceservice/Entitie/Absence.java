package com.example.absenceservice.Entitie;

import com.example.absenceservice.Model.Course;
import com.example.absenceservice.Model.Professor;
import com.example.absenceservice.Model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long studentId;
    @Column(nullable = false)
    private Long professorId;
    @Column(nullable = false)
    private Long courseId;
    private Boolean justified=false;
    @Temporal(TemporalType.DATE) @Column(nullable = false)
    private LocalDate absenceDate;

    @Transient
    private Course course;
    @Transient
    private Student student;
    @Transient
    private Professor professor;
}
