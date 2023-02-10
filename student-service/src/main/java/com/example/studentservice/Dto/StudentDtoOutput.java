package com.example.studentservice.Dto;

import com.example.studentservice.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDtoOutput {
    private String fullName;
    private String NID;
    private Gender gender;
    private String address;
    private Boolean enabled;
}

