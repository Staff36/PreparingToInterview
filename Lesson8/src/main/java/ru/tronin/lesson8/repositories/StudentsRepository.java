package ru.tronin.lesson8.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tronin.lesson8.models.Student;

@Repository
public interface StudentsRepository extends JpaRepository<Student, Long> {

}
