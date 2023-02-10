package com.example.professorservice.Dto;

import com.example.professorservice.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDtoOutput {
    private String fullName;
    private String NID;
    private Gender gender;
    private String address;
    private Boolean enabled;
}
