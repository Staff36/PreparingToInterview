package ru.tronin.lesson7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tronin.lesson7.exceptions.NoEntityException;
import ru.tronin.lesson7.models.Student;
import ru.tronin.lesson7.services.StudentService;

@Controller
@RequestMapping(path = "/students")
public class StudentsController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public String createStudent(@ModelAttribute("stud") Student student){
        studentService.create(student);
        return "redirect:/students";
    }

    @GetMapping
    public String getAllStudents(Model model){
        model.addAttribute("studs", studentService.getAllStudents());
        return "students/students";
    }

    @GetMapping("/{id}")
    public String getStudent(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getEntityById(id));
        return "students/show";
    }

    @GetMapping("/new")
    public String newStudent(Model model){
        model.addAttribute("stud", new Student());
        return "students/new";
    }

    @GetMapping("/{id}/edit")
    public String editStudent(Model model, @PathVariable Long id){
        try {
            model.addAttribute("stud", studentService.getEntityById(id));
        } catch (NoEntityException ignored){
            return "students/notFound";
        }
        return "students/edit";
    }

    @PatchMapping("/{id}")
    public String updateStudent(@ModelAttribute("stud")  Student student,
                                @PathVariable Long id){
        studentService.update(student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.delete(id);
        return "redirect:/students";
    }
}
