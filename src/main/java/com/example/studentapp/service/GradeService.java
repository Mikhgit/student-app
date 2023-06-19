package com.example.studentapp.service;

import com.example.studentapp.model.Grade;
import com.example.studentapp.service.form.GradeForm;

import java.util.List;

public interface GradeService {
    List<Grade> findAll();

    void update(Long id, GradeForm form);
}
