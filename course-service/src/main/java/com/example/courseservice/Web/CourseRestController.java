package com.example.courseservice.Web;

import com.example.courseservice.Dto.CourseDtoInput;
import com.example.courseservice.Dto.CourseDtoOutput;
import com.example.courseservice.Entitie.Course;
import com.example.courseservice.Repository.CourseRepository;
import com.example.courseservice.Service.CourseService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin("*")
public class CourseRestController {
    private CourseRepository courseRepository;
    private CourseService courseService;

    public CourseRestController(CourseRepository courseRepository, CourseService courseService) {
        this.courseRepository = courseRepository;
        this.courseService = courseService;
    }

    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/courses")
    public List<Course> courseList(){
        return courseRepository.findAll();
    }
    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/courses/{id}")
    public Course course(@PathVariable Long id){
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Le course %s n'existe pas!",id)));
    }
    @PreAuthorize("hasAuthority('STUFF')")
    @PostMapping("/courses")
    public CourseDtoOutput saveCourse(@RequestBody CourseDtoInput professor){
        return courseService.addCourse(professor);
    }
    @PreAuthorize("hasAuthority('STUFF')")
    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course){
        Course courseById =  courseRepository.findById(id).get();

        if(course.getName() != null) courseById.setName(course.getName());
        if(course.getDescription() != null) courseById.setDescription(course.getDescription());
        if(course.getEndDate() != null) courseById.setEndDate(course.getEndDate());
        if(course.getStartDate() != null) courseById.setStartDate(course.getStartDate());
        if(course.getNbrSeance() != 0) courseById.setNbrSeance(course.getNbrSeance());
        if(course.getGrpId() != null) courseById.setGrpId(course.getGrpId());
        if(course.getProfessorId() != null) courseById.setProfessorId(course.getProfessorId());

        return courseRepository.save(courseById);
    }
    @PreAuthorize("hasAuthority('STUFF')")
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);

}
    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/courses/courseById/{grpId}")
    public List<Course> courseByGrp(@PathVariable Long grpId){
        return courseService.courseByGrp(grpId);
    }
    @PreAuthorize("hasAuthority('PROFS')")
    @GetMapping("/courses/professorById/{professorId}")
    public List<Course> courseByProfessorId(@PathVariable Long professorId){
        return courseService.courseByProfessorId(professorId);
    }
}

