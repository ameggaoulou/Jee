package com.example.studentservice.Dto;

import com.example.studentservice.Entitie.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrpDtoInput {
    private Long id;
    private String name;
    @OneToMany(mappedBy = "grp")
    private List<Student> students;
}
