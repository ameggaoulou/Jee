package com.example.studentservice.Dto;

import com.example.studentservice.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDtoInput {
    private String fullName;
    private Date birthDate;
    private String NID;
    private Gender gender;
    private String contactNo;
    private String address;

}
