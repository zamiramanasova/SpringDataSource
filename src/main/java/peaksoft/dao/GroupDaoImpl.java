package peaksoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Group;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class GroupDaoImpl implements GroupDao{

    private EntityManagerFactory entityManager;

    @Autowired
    public GroupDaoImpl(EntityManagerFactory entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Group> groupList() {
        EntityManager em = entityManager.createEntityManager();
        List<Group> groupList = em.createQuery("Select g from Group g").getResultList();
        em.close();
        return groupList;
    }

    @Override
    public void saveGroup(Group group) {
        EntityManager em = entityManager.createEntityManager();
        em.getTransaction().begin();
        em.persist(group);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Group findId(Long id) {
        EntityManager em = entityManager.createEntityManager();
        Group group = em.find(Group.class, id);
        em.close();
        return group;
    }

    @Override
    public void update(Group group) {
        EntityManager em = entityManager.createEntityManager();
        em.getTransaction().begin();
        em.merge(group);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManager.createEntityManager();
        Group group = em.find(Group.class, id);
        em.getTransaction().begin();
        em.remove(group);
        em.getTransaction().commit();
        em.close();
    }
}
