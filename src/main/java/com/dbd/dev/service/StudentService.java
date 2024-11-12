package com.dbd.dev.service;

import com.dbd.dev.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudentProfile(Student student);

    List<Student> getAllStudent();

    void deleteStudent(Long id);
}
