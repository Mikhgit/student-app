package com.example.studentapp.service;

import com.example.studentapp.model.Student;
import com.example.studentapp.service.form.StudentForm;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    Student getById(Long id);

    void create(StudentForm form);

    void update(Long id, StudentForm form);

    void delete(Long id);
}
