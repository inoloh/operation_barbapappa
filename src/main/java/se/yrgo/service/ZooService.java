package se.yrgo.service;

import se.yrgo.domain.Animal;
import se.yrgo.domain.Employee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ZooService {
    public void executeAnimal(Animal animal);
    public void emptyFreezer();
    public void putInFreezer(Animal animal);
    public void buyAnimal();
    public List<Animal> showAllAnimals();
    public List<Animal> showSickAnimals();
}
