package com.example.absenceservice.Model;
import com.example.absenceservice.Enum.Gender;
import lombok.Data;
import java.util.Date;


@Data
public class Student {
    private Long id;
    private String fullName;
    private Date birthDate;
    private String NID; //CIN
    private Gender gender;
    private String contactNo;
    private String address;
    private Boolean enabled;
    private int NbrAbsence=0;
}
