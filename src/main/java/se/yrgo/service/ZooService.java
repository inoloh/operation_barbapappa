package se.yrgo.service;

import se.yrgo.domain.Animal;
import se.yrgo.domain.Employee;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ZooService {
    public void executeAnimal(int animalId);
    public void removeAnimalFromFreezer(Animal animal);
    public void putInFreezer(Animal animal);
    public void buyAnimal(Animal animal);
    public List<Animal> showAllAnimals();
    public List<Animal> showSickAnimals();
    public Animal getAnimalById(int animalId);
}
