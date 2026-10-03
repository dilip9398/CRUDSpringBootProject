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

        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id){

        Optional<Student> studentReso = studentRepository.findById(id);

        if(studentReso.isPresent()){
            return studentReso.get();
        }
        return  null;
    }

    public List<Student> getAllStudent(){

        List<Student> studentlists = studentRepository.findAll();

        return studentlists;
    }

    public Student updateStudent(Long id, Student studentReq){
         Optional<Student> exixtingStudent = studentRepository.findById(id);

        if(exixtingStudent.isEmpty()){
            return null;
        }

        Student studentTosave = exixtingStudent.get();
        studentTosave.setName(studentReq.getName());
        studentTosave.setAge(studentReq.getAge());
        studentTosave.setEmail(studentReq.getEmail());
        studentTosave.setSubject(studentReq.getSubject());
        studentTosave.setRollNo(studentReq.getRollNo());

        return  studentRepository.save(studentTosave);
    }

    public Boolean deleteStudent(Long id){

        Boolean isthere = studentRepository.existsById(id);

        if (!isthere) return false;


        studentRepository.deleteById(id);
        return  true;
    }
}
