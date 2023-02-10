package com.example.professorservice.Web;

import com.example.professorservice.Dto.ProfessorDtoInput;
import com.example.professorservice.Dto.ProfessorDtoOutput;
import com.example.professorservice.Entitie.Professor;
import com.example.professorservice.Repository.ProfessorRepository;
import com.example.professorservice.Services.ProfessorService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin("*")
public class ProfessorRestController {
    private ProfessorRepository professorRepository;
    private ProfessorService professorService;

    public ProfessorRestController(ProfessorRepository professorRepository, ProfessorService professorService) {
        this.professorRepository = professorRepository;
        this.professorService = professorService;
    }
    @PreAuthorize("hasAuthority('STUFF')")
    @GetMapping("/professors")
    public List<Professor> ProfessorList(){
        return professorRepository.findAll();
    }
    @PreAuthorize("hasAuthority('STUFF')")
    @PostMapping("/professors")
    public ProfessorDtoOutput saveProfessor(@RequestBody ProfessorDtoInput professor){
        return professorService.addProfessor(professor);
    }
    @PreAuthorize("hasAuthority('STUFF')")
    @GetMapping("/professors/{id}")
    public Professor Professor(@PathVariable Long id){
        return professorRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Le professor %s n'existe pas!",id)));
    }
    @PreAuthorize("hasAuthority('STUFF')")
    @PutMapping("/professors/{id}")
    public Professor updateProfessor(@PathVariable Long id, @RequestBody Professor professor){
        Professor professorById =  professorRepository.findById(id).get();

        if(professor.getFullName() != null) professorById.setFullName(professor.getFullName());
        if(professor.getAddress() != null) professorById.setAddress(professor.getAddress());
        if(professor.getGender() != null) professorById.setGender(professor.getGender());
        if(professor.getEnabled() != null) professorById.setEnabled(professor.getEnabled());
        if(professor.getNID() != null) professorById.setNID(professor.getNID());
        if(professor.getContactNo() != null) professorById.setContactNo(professor.getContactNo());

        return professorRepository.save(professorById);
    }

    @PreAuthorize("hasAuthority('STUFF')")
    @DeleteMapping("/professors/{id}")
    public void deleteSProfessor(@PathVariable Long id){
        professorRepository.deleteById(id);
    }
}
