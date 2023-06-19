package com.example.studentapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GradeFormDto {

    @NotBlank(message = "поле text не должно быть пустым")
    private String text;
}
