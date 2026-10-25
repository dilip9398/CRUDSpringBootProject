package com.dilip.CrudSpringbootDemo.controller;


import com.dilip.CrudSpringbootDemo.entity.Student;
import com.dilip.CrudSpringbootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createStudent = studentService.createStudent(student);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createStudent);
    }

    @GetMapping("/get")
    public  ResponseEntity<Student> getStudent(@RequestParam Long id){

        Student getdeatails = studentService.getStudent(id);

        if (getdeatails == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getdeatails);
    }

    @GetMapping("/getAll")
    public  ResponseEntity<List<Student>> getAllStudent(){

        List<Student>  studentList = studentService.getAllStudent();

        if (studentList == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update")
    public  ResponseEntity<Student> updateStudent(@RequestParam Long id, @RequestBody
                                                  Student studentreq){

        Student updatedeatails = studentService.updateStudent(id, studentreq);

        if (updatedeatails == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedeatails);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){

        Boolean isDeleted = studentService.deleteStudent(id);

        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Deleted");
    }

    @PatchMapping("/soft-delete")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){

        Boolean isDeleted = studentService.deleteStudentSoftly(id);

        if (!isDeleted) {
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok("Recorded Deleted");
    }
}
