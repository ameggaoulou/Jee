package com.example.courseservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDtoOutput {
    private Long id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date EndDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date StartDate;
    private int NbrSeance;
    private Long grpId;
    private Long professorId;
}
