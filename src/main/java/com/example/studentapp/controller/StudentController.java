package com.example.studentapp.controller;

import com.example.studentapp.dto.StudentDto;
import com.example.studentapp.dto.StudentFormDto;
import com.example.studentapp.mapper.StudentDtoMapper;
import com.example.studentapp.model.Student;
import com.example.studentapp.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
@Tag(name = "Студенты")
public class StudentController {

    private final StudentService studentService;
    private final StudentDtoMapper mapper;

    @Operation(summary = "Получение списка студентов")
    @GetMapping
    public List<StudentDto> findAll() {
        return studentService.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Получение студента по id")
    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @Operation(summary = "Создание студента")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody StudentFormDto form) {
        studentService.create(mapper.fromDto(form));
    }

    @Operation(summary = "Обновление студента")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @Valid @RequestBody StudentFormDto form) {
        studentService.update(id, mapper.fromDto(form));
    }

    @Operation(summary = "Удаление студента")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
