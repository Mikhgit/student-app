package com.example.studentapp.service.impl;

import com.example.studentapp.exception.ResourceNotFoundException;
import com.example.studentapp.mapper.StudentMapper;
import com.example.studentapp.model.Student;
import com.example.studentapp.repository.StudentRepository;
import com.example.studentapp.service.form.StudentForm;
import com.example.studentapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    @Transactional
    public void create(StudentForm form) {
        Student student = mapper.toStudent(form);
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void update(Long id, StudentForm form) {
        Student student = getById(id);
        mapper.update(student, form);
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
