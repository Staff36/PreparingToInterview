package ru.tronin.lesson8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tronin.lesson8.exceptions.BadRequestException;
import ru.tronin.lesson8.exceptions.NotFoundException;
import ru.tronin.lesson8.models.Student;
import ru.tronin.lesson8.services.StudentService;

import javax.transaction.Transactional;
import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentRestController {

    private final StudentService service;

    @Autowired
    public StudentRestController(StudentService repository) {
        this.service = repository;
    }

    @GetMapping("/all")
    public List<Student> findAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}/id")
    public Student findById(@PathVariable("id") long id) {
        return service.getEntityById(id);
    }

    @Transactional
    @PostMapping()
    public Student create(@RequestBody Student student) {
        if (student.getId() != null) {
            throw new BadRequestException();
        }
        return service.create(student);
    }

    @Transactional
    @PutMapping()
    public Student update(@RequestBody Student student) {
        if (student.getId() == null) {
            throw new BadRequestException();
        }
        return service.update(student);
    }

    @Transactional
    @DeleteMapping("/{id}/id")
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }

    @ExceptionHandler
    public ResponseEntity<Void> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler
    public ResponseEntity<Void> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.badRequest().build();
    }
}
