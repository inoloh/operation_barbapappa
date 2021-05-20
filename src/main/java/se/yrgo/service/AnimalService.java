package se.yrgo.service;

import se.yrgo.domain.Employee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface AnimalService {
    public void executeAnimal(Animal animal);
    public List<Employee> getAllEmployees();
    public List<Employee> searchByLastname(String lastname);
}
