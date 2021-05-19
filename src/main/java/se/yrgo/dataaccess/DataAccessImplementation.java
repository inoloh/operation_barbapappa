package se.yrgo.dataaccess;

import se.yrgo.domain.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DataAccessImplementation implements DataAccess {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void insert(Employee employee) {
        em.persist(employee);
    }

    @Override
    public List<Employee> findAll() {
        Query q = em.createQuery("select employee from Employee employee");
        List<Employee> employees = q.getResultList();
        return employees;
    }

    @Override
    public List<Employee> findByLastname(String lastname) {
        Query q = em.createQuery("select employee from Employee employee where employee.lastname = :lastname");
        q.setParameter("lastname", lastname);
        return q.getResultList();
    }
}
