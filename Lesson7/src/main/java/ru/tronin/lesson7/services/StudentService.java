package ru.tronin.lesson7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tronin.lesson7.exceptions.NoEntityException;
import ru.tronin.lesson7.models.Student;
import ru.tronin.lesson7.repositories.StudentsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentsRepository studentsRepository;

    public Student getEntityById(Long id) {
        Optional<Student> student = studentsRepository.findById(id);
        if(student.isEmpty()){
            throw new NoEntityException("Entity with id =" + id + " not found");
        }
        return student.get();
    }

    public void create(Student product) {
        studentsRepository.saveAndFlush(product);
    }

    public List<Student> getAllStudents(){
        return studentsRepository.findAll();
    }

    public void delete(Long id){
        studentsRepository.deleteById(id);
    }

    public void update(Student student){
        studentsRepository.saveAndFlush(student);
    }
}
