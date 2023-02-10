package com.example.absenceservice.Model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Course {
    private Long id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date StartDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date EndDate;
    private int NbrSeance;
    private Long grpId;
    private Long professorId;
}
