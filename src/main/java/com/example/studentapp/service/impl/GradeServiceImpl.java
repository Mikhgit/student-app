package com.example.studentapp.service.impl;

import com.example.studentapp.exception.ResourceNotFoundException;
import com.example.studentapp.model.Grade;
import com.example.studentapp.repository.GradeRepository;
import com.example.studentapp.service.form.GradeForm;
import com.example.studentapp.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepository repository;

    @Override
    public List<Grade> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void update(Long id, GradeForm form) {
        Grade grade = repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
        grade.setText(form.getText());
        repository.save(grade);
    }
}
