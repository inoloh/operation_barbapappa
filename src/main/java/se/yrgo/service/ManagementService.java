package se.yrgo.service;

import se.yrgo.domain.Employee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ManagementService {
    public void registerEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public List<Employee> searchByLastname(String lastname);
}
