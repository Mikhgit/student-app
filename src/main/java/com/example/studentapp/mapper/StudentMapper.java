package com.example.studentapp.mapper;

import com.example.studentapp.model.Grade;
import com.example.studentapp.model.Student;
import com.example.studentapp.repository.GradeRepository;
import com.example.studentapp.service.form.StudentForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public abstract class StudentMapper {

    @Autowired
    private GradeRepository gradeRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "grade", expression = "java( getGrade(form.getGradeId()) )")
    public abstract Student toStudent(StudentForm form);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "grade", expression = "java( getGrade(form.getGradeId()) )")
    public abstract void update(@MappingTarget Student student, StudentForm form);

    protected Grade getGrade(Long id) {
        if (id == null) {
            return null;
        }
        return gradeRepository.getReferenceById(id);
    }
}
