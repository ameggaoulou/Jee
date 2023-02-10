package com.example.studentservice.Web;

import com.example.studentservice.Dto.GrpDtoInput;
import com.example.studentservice.Dto.GrpDtoOutput;
import com.example.studentservice.Dto.StudentDtoInput;
import com.example.studentservice.Dto.StudentDtoOutput;
import com.example.studentservice.Entitie.Grp;
import com.example.studentservice.Entitie.Student;
import com.example.studentservice.Repository.GrpRepository;
import com.example.studentservice.Repository.StudentRepository;
import com.example.studentservice.Service.GrpService;
import com.example.studentservice.Service.StudentService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class GrpRestController {
    private GrpRepository grpRepository;
    private StudentRepository studentRepository;
    private GrpService grpService;

    public GrpRestController(GrpRepository grpRepository,GrpService grpService,StudentRepository studentRepository) {
        this.grpRepository = grpRepository;
        this.grpService = grpService;
        this.studentRepository=studentRepository;
    }

    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/grps")
    public List<Grp> grpList(){
        return grpRepository.findAll();
    }

    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/grps/{id}")
    public Grp grps(@PathVariable Long id){
        return grpRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Le Groupe %s n'existe pas!",id)));
    }
    @PreAuthorize("hasAuthority('STUFF')")
    @PostMapping("/grps")
    public GrpDtoOutput saveGrp(@RequestBody GrpDtoInput grp){
        return grpService.addGrp(grp);
    }

    @PreAuthorize("hasAuthority('STUFF')")
    @PutMapping("/grps/{id}")
    public Grp updateGrp(@PathVariable Long id, @RequestBody Grp grp){
        Grp grpById =  grpRepository.findById(id).get();

        if(grp.getName() != null) grpById.setName(grp.getName());
        if(grp.getStudents() != null) grpById.setStudents(grp.getStudents());


        return grpRepository.save(grpById);
    }


    @PreAuthorize("hasAuthority('STUFF')")
    @DeleteMapping("/grps/{id}")
    public void deleteGrp(@PathVariable Long id){
        grpRepository.deleteById(id);
    }

    @PreAuthorize("hasAuthority('STUFF')")
    @PutMapping("grps/{id}/{students}")
    public void addStudentToGrp(@PathVariable Long id, @RequestBody List<Student> students){
        grpService.addStudentToGrp(students,id);
    }

}
