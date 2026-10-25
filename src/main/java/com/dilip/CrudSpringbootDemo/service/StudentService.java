package com.dilip.CrudSpringbootDemo.service;


import com.dilip.CrudSpringbootDemo.entity.Student;
import com.dilip.CrudSpringbootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        studentReq.setDeleted(false);
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id){

        Optional<Student> studentReso = studentRepository.findByIdAndDeletedIsFalse(id);

        if(studentReso.isPresent()){
            return studentReso.get();
        }
        return  null;
    }

    public List<Student> getAllStudent(){

        List<Student> studentlists = studentRepository.findByDeletedIsFalse();

        return studentlists;
    }

    public Student updateStudent(Long id, Student studentReq){
         Optional<Student> exixtingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(exixtingStudent.isEmpty()){
            return null;
        }

        Student studentTosave = exixtingStudent.get();
        studentTosave.setName(studentReq.getName());
        studentTosave.setAge(studentReq.getAge());
        studentTosave.setEmail(studentReq.getEmail());
        studentTosave.setSubject(studentReq.getSubject());
        studentTosave.setRollNo(studentReq.getRollNo());

        studentTosave.setDeleted(false);

        return  studentRepository.save(studentTosave);
    }

    public Boolean deleteStudent(Long id){

        Boolean isthere = studentRepository.existsById(id);

        if (!isthere) return false;


        studentRepository.deleteById(id);
        return  true;
    }

    public Boolean deleteStudentSoftly(Long id){

        //get
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()){
            return false;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);

        studentRepository.save(studentToSave);
        return true;
    }
}
