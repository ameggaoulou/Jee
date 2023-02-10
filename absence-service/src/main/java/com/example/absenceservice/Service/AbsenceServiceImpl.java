package com.example.absenceservice.Service;

import com.example.absenceservice.Dto.AbsenceDtoInput;
import com.example.absenceservice.Dto.AbsenceDtoOutput;
import com.example.absenceservice.Entitie.Absence;
import com.example.absenceservice.Mapper.AbsenceMapper;
import com.example.absenceservice.Model.Course;
import com.example.absenceservice.Model.Professor;
import com.example.absenceservice.Model.Student;
import com.example.absenceservice.Repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AbsenceServiceImpl implements AbsenceService{
    @Autowired
    AbsenceRepository absenceRepository;
    @Autowired
    AbsenceMapper absenceMapper;
    CourseRestClient courseRestClient;
    ProfessorRestClient professorRestClient;
    StudentRestClient studentRestClient;
    @Override
    public AbsenceDtoOutput addAbsence(AbsenceDtoInput absenceDtoInput) {
        Student student = studentRestClient.findStudentById(absenceDtoInput.getCourseId().longValue());
        Course cour = courseRestClient.findCourseById(absenceDtoInput.getCourseId().longValue());
        Professor professor=professorRestClient.findProfessorById(absenceDtoInput.getProfessorId().longValue());
        Absence absence = new Absence();
        absence.setAbsenceDate(absenceDtoInput.getAbsenceDate());
        absence.setCourse(cour);
        absence.setCourseId(absenceDtoInput.getCourseId());
        absence.setJustified(absenceDtoInput.getJustified());
        absence.setProfessor(professor);
        absence.setProfessorId(absenceDtoInput.getProfessorId());
        absence.setStudent(student);
        absence.setStudentId(absenceDtoInput.getStudentId());

        Absence savedAbsence = absenceRepository.save(absence);
        AbsenceDtoOutput absenceDtoOutput = absenceMapper.fromAbsence(savedAbsence);
        return absenceDtoOutput;
    }

    @Override
    public void deleteAbsence(Long id) {
        Absence absence = absenceRepository.findById(id).get();
        absence.setJustified(true);
        absenceRepository.save(absence);

    }

    @Override
    public List<Absence> findAllByStudent(Long studentId) {

        return absenceRepository.findAllByStudentId(studentId);
    }

    @Override
    public List<Absence> findAllByCourse(Long courseId) {
        return absenceRepository.findAllByCourseId(courseId);
    }

    @Override
    public List<Absence> findAllByProfessor(Long professorId) {
        return absenceRepository.findAllByProfessorId(professorId); }




}
