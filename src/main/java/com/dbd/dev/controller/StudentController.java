package com.dbd.dev.controller;

import com.dbd.dev.entity.Student;
import com.dbd.dev.service.StudentService;
import jakarta.servlet.http.PushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public ResponseEntity<Object> createStudentProfile(@RequestBody Student student) {
        Student saveStudent = studentService.createStudentProfile(student);
        return ResponseEntity.ok(saveStudent);
    }

    @GetMapping
    public ResponseEntity<Object> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        return ResponseEntity.ok(studentList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student Deleted successfully.");
    }

}
