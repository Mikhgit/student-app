package com.example.studentapp.mapper;

import com.example.studentapp.dto.StudentDto;
import com.example.studentapp.dto.StudentFormDto;
import com.example.studentapp.model.Student;
import com.example.studentapp.service.form.StudentForm;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface StudentDtoMapper {

    StudentDto toDto(Student student);

    StudentForm fromDto(StudentFormDto dto);
}
