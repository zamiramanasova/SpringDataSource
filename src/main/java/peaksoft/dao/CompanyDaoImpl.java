package peaksoft.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao{


    private EntityManagerFactory entityManager;

    @Autowired
    public CompanyDaoImpl(EntityManagerFactory entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Company> companyList() {
        EntityManager em = entityManager.createEntityManager();
        List<Company> companyList = em.createQuery("Select c from Company c").getResultList();
        em.close();
        return companyList;
    }

    @Override
    public void saveCompany(Company company) {
        EntityManager em = entityManager.createEntityManager();
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Company findId(Long id) {
        EntityManager em = entityManager.createEntityManager();
        Company company = em.find(Company.class, id);
        em.close();
        return company;
    }

    @Override
    public void update(Company company) {
        EntityManager em = entityManager.createEntityManager();
        em.getTransaction().begin();
        em.merge(company);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManager.createEntityManager();
        Company company = em.find(Company.class, id);
        em.getTransaction().begin();
        em.remove(company);
        em.getTransaction().commit();
        em.close();
    }
}
