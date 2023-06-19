package com.example.studentapp.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class StudentFormDto {

    @NotEmpty(message = "имя не должно быть пустым")
    String name;
    @NotEmpty(message = "фамилия не должна быть пустой")
    String surname;
    @NotEmpty(message = "отчество не должно быть пустым")
    String patronymic;
    @NotNull(message = "необходимо указать дату рождения")
    LocalDate birthday;
    @Nullable
    Long gradeId;
}
