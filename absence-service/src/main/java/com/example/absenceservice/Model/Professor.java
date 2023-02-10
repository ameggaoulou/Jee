package com.example.absenceservice.Model;

import com.example.absenceservice.Enum.Gender;
import lombok.Data;

@Data
public class Professor {
    private Long id;
    private String fullName;
    private String NID; //CIN
    private Gender gender;
    private String contactNo;
    private String address;
    private Boolean enabled;
}
