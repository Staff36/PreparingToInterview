package ru.tronin.lesson8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tronin.lesson8.exceptions.NotFoundException;
import ru.tronin.lesson8.models.Student;
import ru.tronin.lesson8.repositories.StudentsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentsRepository studentsRepository;

    public Student getEntityById(Long id) {
        Optional<Student> student = studentsRepository.findById(id);
        if(student.isEmpty()){
            throw new NotFoundException("Entity with id =" + id + " not found");
        }
        return student.get();
    }

    public Student create(Student product) {

        return studentsRepository.saveAndFlush(product);

    }

    public List<Student> getAllStudents(){
        return studentsRepository.findAll();
    }

    public void delete(Long id){
        studentsRepository.deleteById(id);
    }

    public Student update(Student student){
        return studentsRepository.saveAndFlush(student);
    }
}
