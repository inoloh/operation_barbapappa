package se.yrgo.dataaccess;

import se.yrgo.domain.Animal;
import se.yrgo.domain.Employee;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DataAccess {
    public void deleteAnimal(Animal animal);
    public void deleteAnimalFromFreezer(Animal animal);
    public void insertToFreezer(Animal animal);
    public void insertAnimal(Animal animal);
    public List<Animal> findAllAnimals();
    public List<Animal> findSickAnimals();
}
