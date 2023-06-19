package com.example.studentapp.service.form;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class StudentForm {

    String name;
    String surname;
    String patronymic;
    LocalDate birthday;
    Long gradeId;
}
