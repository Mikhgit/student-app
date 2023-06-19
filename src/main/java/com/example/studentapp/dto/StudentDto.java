package com.example.studentapp.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class StudentDto {

    Long id;
    String name;
    String surname;
    String patronymic;
    LocalDate birthday;
    GradeDto grade;
}
