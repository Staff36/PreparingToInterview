package ru.tronin.dao.impl;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.tronin.dao.iDao;
import ru.tronin.models.Student;

import java.util.List;
@AllArgsConstructor
public class StudentDaoImpl implements iDao <Student> {

    private SessionFactory factory;


    @Override
    public Student getEntityById(Long id) {
        try(Session session = factory.openSession()) {
            session.getTransaction().begin();
            Student studentFromDb = session.get(Student.class ,id);
            session.getTransaction().commit();
            return studentFromDb;
        }
    }

    @Override
    public List<Student> getAllEntities() {
        try(Session session = factory.openSession()) {
            session.getTransaction().begin();
            List<Student> students= session.createQuery("from Student").list();
            session.getTransaction().commit();
            return students;
        }
    }

    @Override
    public void saveOrUpdateEntity(Student student) {
        try(Session session = factory.openSession()) {
            session.getTransaction().begin();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteEntity(Student student) {
        try(Session session = factory.openSession()) {
            session.getTransaction().begin();
            session.delete(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteEntityById(Long id) {
        try(Session session = factory.openSession()) {
            session.getTransaction().begin();
            Query query = session.createQuery("delete from Student s where s.id = :myId");
            query.setParameter("myId", id);
            query.executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveAll(List<Student> students) {
        try(Session session = factory.openSession()) {
            session.getTransaction().begin();
            students.forEach(session::saveOrUpdate);
            session.getTransaction().commit();
        }
    }
}
