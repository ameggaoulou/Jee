package com.example.professorservice.Dto;

import com.example.professorservice.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDtoInput {
    private String fullName;
    private String NID;
    private Gender gender;
    private String contactNo;
    private String address;
}
