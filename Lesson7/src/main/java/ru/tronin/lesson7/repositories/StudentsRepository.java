package ru.tronin.lesson7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tronin.lesson7.models.Student;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {

}
