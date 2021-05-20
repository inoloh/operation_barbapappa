package se.yrgo.service;

import se.yrgo.dataaccess.DataAccess;
import se.yrgo.domain.Employee;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ServiceImplementation implements AnimalService {

    @Inject
    private DataAccess dao;

    @Override
    public void registerEmployee(Employee employee) {
        dao.insert(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return dao.findAll();
    }

    @Override
    public List<Employee> searchByLastname(String lastname) {
        return dao.findByLastname(lastname);
    }
}
