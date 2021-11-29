package ru.tronin;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.tronin.dao.iDao;
import ru.tronin.dao.impl.StudentDaoImpl;
import ru.tronin.models.Student;

import java.util.Random;


public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        iDao<Student> studentsDao = new StudentDaoImpl(sessionFactory);
//        addStudentsToDb(studentsDao);
        updateStudent(studentsDao, 15L);
        displayStudentById(studentsDao, 5L);
        getAllStudents(studentsDao);
        deleteStudentById(studentsDao, 10L);
        getAllStudents(studentsDao);
    }

    public static void addStudentsToDb(iDao<Student> studentsDao){
        Random random = new Random(4);
        for (int i = 0; i < 1000; i++) {
            Student student = new Student();
            student.setName("Student " + i);
            student.setMark( 1 + random.nextFloat());
            studentsDao.saveOrUpdateEntity(student);
        }
        System.out.println("Students have already created");
    }

    public static void updateStudent(iDao<Student> studentsDao, Long id){
        Student student = studentsDao.getEntityById(id);
        System.out.println("Before updating - >" + student);
        student.setMark( -50F);
        studentsDao.saveOrUpdateEntity(student);
        Student student2 = studentsDao.getEntityById(id);;
        System.out.println("After updating - >" + student2);
    }

    public static void displayStudentById(iDao<Student> studentsDao, Long id){
        System.out.println("Getting student by id: " + studentsDao.getEntityById(id));
    }

    public static void deleteStudentById(iDao<Student> studentsDao, Long id){
        studentsDao.deleteEntityById(id);
        System.out.println("Student has been deleted");
    }

    public static void getAllStudents(iDao<Student> studentsDao){
        System.out.println("Getting all students");
        System.out.println("Got " + studentsDao.getAllEntities().size() + " students");

    }


}
