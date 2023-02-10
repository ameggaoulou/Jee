package com.example.absenceservice.Web;

import com.example.absenceservice.Dto.AbsenceDtoInput;
import com.example.absenceservice.Dto.AbsenceDtoOutput;
import com.example.absenceservice.Entitie.Absence;
import com.example.absenceservice.Mapper.AbsenceMapper;
import com.example.absenceservice.Model.Course;
import com.example.absenceservice.Model.Professor;
import com.example.absenceservice.Model.Student;
import com.example.absenceservice.Repository.AbsenceRepository;
import com.example.absenceservice.Service.AbsenceService;
import com.example.absenceservice.Service.CourseRestClient;
import com.example.absenceservice.Service.ProfessorRestClient;
import com.example.absenceservice.Service.StudentRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin("*")

public class AbsenceRestController {
    private AbsenceRepository absenceRepository;
    private AbsenceService absenceService;
    private CourseRestClient courseRestClient;
    private StudentRestClient studentRestClient;
    private ProfessorRestClient professorRestClient;

    public AbsenceRestController(AbsenceRepository absenceRepository, AbsenceService absenceService) {
        this.absenceRepository = absenceRepository;
        this.absenceService = absenceService;
    }
    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/absences")
    public List<Absence> absenceList(){
        return absenceRepository.findAll();
    }
    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/absences/{id}")
    public Absence absences(@PathVariable Long id){
        return absenceRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("L absence %s n'existe pas!",id)));
    }
    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/absences/professor/{id}")
    public List<Absence> absenceByProfessorId(@PathVariable Long id){
        Professor professor = professorRestClient.findProfessorById(id.longValue());
        return absenceService.findAllByProfessor(professor.getId());
    }

    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/absences/courses/{id}")
    public List<Absence> absenceByCoursesId(@PathVariable Long id){
        Course course = courseRestClient.findCourseById(id.longValue());
        return absenceService.findAllByCourse(course.getId());}

    @PreAuthorize("hasAuthority('ETUD')")
    @GetMapping("/absences/student/{id}")
    public List<Absence> absenceByStudentId(@PathVariable Long id){
        Student student = studentRestClient.findStudentById(id.longValue());
        return absenceService.findAllByStudent(student.getId());

    }

    @PreAuthorize("hasAuthority('STUFF')")
    @PutMapping("/absences/{id}/justified")
    public void justifiedAbsence(@PathVariable Long id){
        absenceService.deleteAbsence(id);
    }

    @PreAuthorize("hasAuthority('PROFS')")
    @PostMapping("/absences")
    public AbsenceDtoOutput saveAbsence(@RequestBody AbsenceDtoInput absence){
        return absenceService.addAbsence(absence);
    }


}
