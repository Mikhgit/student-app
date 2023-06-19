package com.example.studentapp.controller;

import com.example.studentapp.dto.GradeDto;
import com.example.studentapp.dto.GradeFormDto;
import com.example.studentapp.service.GradeService;
import com.example.studentapp.service.form.GradeForm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students/grades")
@RequiredArgsConstructor
@Tag(name = "Успеваемость")
public class GradeController {

    private final GradeService gradeService;

    @Operation(summary = "Получение значений справочника успеваемости")
    @GetMapping
    public List<GradeDto> findAll() {
        return gradeService.findAll().stream()
                .map(grade -> new GradeDto(grade.getId(), grade.getText()))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Обновление объекта успеваемости")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @Valid @RequestBody GradeFormDto form) {
        gradeService.update(id, new GradeForm(form.getText()));
    }
}
