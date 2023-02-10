package com.example.studentservice.Service;

import com.example.studentservice.Dto.StudentDtoInput;
import com.example.studentservice.Dto.StudentDtoOutput;
import com.example.studentservice.Entitie.Student;
import com.example.studentservice.Mapper.StudentMapper;
import com.example.studentservice.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;
    @Override
    public StudentDtoOutput addStudent(StudentDtoInput studentDtoInput) {
        Student student = new Student();
        student.setFullName(studentDtoInput.getFullName());
        student.setGender(studentDtoInput.getGender());
        student.setAddress(studentDtoInput.getAddress());
        student.setNID(studentDtoInput.getNID());
        student.setContactNo(studentDtoInput.getContactNo());
        student.setBirthDate(new Date());
        student.setEnabled(Boolean.TRUE);
        Student savedStudent = studentRepository.save(student);

        StudentDtoOutput studentDtoOutput = studentMapper.fromStudent(savedStudent);
        return studentDtoOutput;
    }

    @Override
    public StudentDtoOutput updateStudent(Long id, StudentDtoInput student) {
        Student studentById =  studentRepository.findById(id).get();
        if(studentById != null){
            studentById.setFullName(student.getFullName());
            studentById.setAddress(student.getAddress());
            studentById.setGender(student.getGender());
            studentById.setNID(student.getNID());
            studentById.setBirthDate(student.getBirthDate());
            studentById.setContactNo(student.getContactNo());
            return studentMapper.fromStudent(studentById);
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public int ShowNbrAbsenceByName(String name) {
        Student studentRepositoryByFullName =studentRepository.findByFullNameContains(name);
        int i= studentRepositoryByFullName.getNbrAbsence();
        return i;

    }
    @Override
    public int ShowNbrAbsenceById(Long id) {
        Student studentById =  studentRepository.findById(id).get();
        int j= studentById.getNbrAbsence();
        return j;

    }
}
