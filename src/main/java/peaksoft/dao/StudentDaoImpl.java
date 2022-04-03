package peaksoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    private EntityManagerFactory entityManager;

    @Autowired
    public StudentDaoImpl(EntityManagerFactory entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> studentList() {
        EntityManager em = entityManager.createEntityManager();
        List<Student> studentList = em.createQuery("Select s from Student s").getResultList();
        em.close();
        return studentList;
    }

    @Override
    public void saveStudent(Student student) {
        EntityManager em = entityManager.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Student findId(Long id) {
        EntityManager em = entityManager.createEntityManager();
        Student student = em.find(Student.class, id);
        em.close();
        return student;
    }

    @Override
    public void update(Student student) {
        EntityManager em = entityManager.createEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManager.createEntityManager();
        Student student = em.find(Student.class, id);
        em.getTransaction().begin();
        em.remove(student);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Student> search( String firstName) {
        EntityManager em = entityManager.createEntityManager();
        em.getTransaction().begin();
        List<Student> studentList = em.createQuery("SELECT s FROM Student s WHERE s.firstName LIKE :firstName").getResultList();
        em.getTransaction().commit();
        em.close();
        return studentList;
    }
}
