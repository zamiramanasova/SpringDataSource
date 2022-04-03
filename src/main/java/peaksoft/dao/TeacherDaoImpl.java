package peaksoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Teacher;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class TeacherDaoImpl implements TeacherDao{

    private EntityManagerFactory entityManager;

    @Autowired
    public TeacherDaoImpl(EntityManagerFactory entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Teacher> teacherList() {
        EntityManager em = entityManager.createEntityManager();
        List<Teacher> teacherList = em.createQuery("Select t from Teacher t").getResultList();
        em.close();
        return teacherList;
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        EntityManager em = entityManager.createEntityManager();
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Teacher findId(Long id) {
        EntityManager em = entityManager.createEntityManager();
        Teacher teacher = em.find(Teacher.class, id);
        em.close();
        return teacher;
    }

    @Override
    public void update(Teacher teacher) {
        EntityManager em = entityManager.createEntityManager();
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManager.createEntityManager();
        Teacher teacher = em.find(Teacher.class, id);
        em.getTransaction().begin();
        em.remove(teacher);
        em.getTransaction().commit();
        em.close();
    }
}
