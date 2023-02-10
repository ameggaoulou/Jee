package com.example.courseservice.Service;

import com.example.courseservice.Dto.CourseDtoInput;
import com.example.courseservice.Dto.CourseDtoOutput;
import com.example.courseservice.Entitie.Course;
import com.example.courseservice.Mapper.CourseMapper;
import com.example.courseservice.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseMapper courseMapper;

    @Override
    public CourseDtoOutput addCourse(CourseDtoInput courseDtoInput) {
        Course course = new Course();
        course.setName(courseDtoInput.getName());
        course.setDescription(courseDtoInput.getDescription());
        course.setEndDate(courseDtoInput.getEndDate());
        course.setStartDate(courseDtoInput.getStartDate());
        course.setNbrSeance(courseDtoInput.getNbrSeance());
        course.setGrpId(courseDtoInput.getGrpId());
        course.setProfessorId(courseDtoInput.getProfessorId());

        Course savedCourse = courseRepository.save(course);
        CourseDtoOutput courseDtoOutput = courseMapper.fromCourse(savedCourse);
        return courseDtoOutput;
    }

    @Override
    public CourseDtoOutput updateCourse(Long id, CourseDtoInput course) {
        Course courseById =  courseRepository.findById(id).get();
        if(courseById != null){
            courseById.setName(course.getName());
            courseById.setDescription(course.getDescription());
            courseById.setEndDate(course.getEndDate());
            courseById.setStartDate(course.getStartDate());
            courseById.setNbrSeance(course.getNbrSeance());
            courseById.setGrpId(course.getGrpId());
            courseById.setProfessorId(course.getProfessorId());
            return courseMapper.fromCourse(courseById);
        }
        return null;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);

    }

    @Override
    public List<Course> courseByGrp(Long GrpId) {
        List<Course> courseListByGrp = courseRepository.findAllByGrpId(GrpId);
        return courseListByGrp;
    }

    @Override
    public List<Course> courseByProfessorId(Long ProfessorId) {
        List<Course> courseList = courseRepository.findAllByProfessorId(ProfessorId);
        return courseList;
    }
}
