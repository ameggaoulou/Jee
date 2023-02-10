package com.example.studentservice.Web;

import com.example.studentservice.Dto.StudentDtoInput;
import com.example.studentservice.Dto.StudentDtoOutput;
import com.example.studentservice.Entitie.Grp;
import com.example.studentservice.Entitie.Student;
import com.example.studentservice.Repository.StudentRepository;
import com.example.studentservice.Service.StudentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin("*")
public class StudentRestController {
    private StudentRepository studentRepository;
    private StudentService studentService;

    public StudentRestController(StudentRepository studentRepository, StudentService studentService) {
        this.studentRepository = studentRepository;
        this.studentService = studentService;
    }
    @PreAuthorize("hasAuthority('STUFF')")
    @PostMapping("/students")
    public StudentDtoOutput saveStudent(@RequestBody StudentDtoInput student){
        return studentService.addStudent(student);
    }
    @PreAuthorize("hasAuthority('STUFF')")
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student studentById =  studentRepository.findById(id).get();

        if(student.getFullName() != null) studentById.setFullName(student.getFullName());
        if(student.getAddress() != null) studentById.setAddress(student.getAddress());
        if(student.getGender() != null) studentById.setGender(student.getGender());
        if(student.getEnabled() != null) studentById.setEnabled(student.getEnabled());
        if(student.getNID() != null) studentById.setNID(student.getNID());
        if(student.getBirthDate() != null) studentById.setBirthDate(student.getBirthDate());
        if(student.getContactNo() != null) studentById.setContactNo(student.getContactNo());

        return studentRepository.save(studentById);
    }
    @PreAuthorize("hasAuthority('STUFF')")
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }




    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/students/grp")
    public List<Student> studentListByGrp(@RequestBody Grp grp) {
        List<Student> listS = studentRepository.findAllByGrp(grp);
        return listS;}

    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/students")
    public List<Student> studentList(){
        return studentRepository.findAll();
    }

    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/students/")
    public List<Student> studentList(@RequestParam(required = false) Long id, @RequestParam(required = false) String name) {
        if (id != null) {
            return Collections.singletonList(studentRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Le student %s n'existe pas!", id))));
        }
        if (name != null) {
            return Collections.singletonList(studentRepository.findByFullNameContains(name));
        }
        return studentRepository.findAll();
    }
    @PreAuthorize("hasAuthority('ETUD')")
    @GetMapping("/students/absence/")
    public int showNbrAbsences(@RequestParam(required = false) Long id, @RequestParam(required = false) String name) {
        if (id != null) {
            return studentService.ShowNbrAbsenceById(id);
        }
        if (name != null) {
            return studentService.ShowNbrAbsenceByName(name);
        }
        throw new IllegalArgumentException("Either id or name must be provided as request parameter");
    }




}
