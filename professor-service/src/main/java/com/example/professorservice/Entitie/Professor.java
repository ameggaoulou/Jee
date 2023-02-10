package com.example.professorservice.Entitie;

import com.example.professorservice.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50, nullable = false)
    private String fullName;

    @Column(length = 8,  nullable = false)
    private String NID; //CIN
    @Column(nullable = false) @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(nullable = false)
    private String contactNo;
    @Column(length = 100, nullable = false)
    private String address;
    @Column(nullable = false)
    private Boolean enabled;
}
