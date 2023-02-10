package com.example.courseservice.Entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date StartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date EndDate;
    @Column(nullable = false)
    private int NbrSeance;
    private Long grpId;
    private Long professorId;
}
