package peaksoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import peaksoft.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao{

    private EntityManagerFactory entityManager;

    @Autowired
    public CourseDaoImpl(EntityManagerFactory entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> courseList() {
        EntityManager em = entityManager.createEntityManager();
        List<Course> courseList = em.createQuery("Select c from Course c").getResultList();
        em.close();
        return courseList;
    }

    @Override
    public void saveCourse(Course course) {
        EntityManager em = entityManager.createEntityManager();
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Course findId(Long id) {
        EntityManager em = entityManager.createEntityManager();
        Course course = em.find(Course.class, id);
        em.close();
        return course;
    }

    @Override
    public void update(Course course) {
        EntityManager em = entityManager.createEntityManager();
        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManager.createEntityManager();
        Course course = em.find(Course.class, id);
        em.getTransaction().begin();
        em.remove(course);
        em.getTransaction().commit();
        em.close();
    }
}
