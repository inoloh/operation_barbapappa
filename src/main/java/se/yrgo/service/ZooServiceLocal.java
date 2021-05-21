package se.yrgo.service;

import se.yrgo.domain.Animal;
import se.yrgo.domain.Zone;

import javax.ejb.Local;
import javax.ejb.Remote;
import java.util.List;

@Local
public interface ZooServiceLocal {
    public void executeAnimal(int animalId);
    public void removeAnimalFromFreezer(Animal animal);
    public void putInFreezer(Animal animal);
    public void buyAnimal(Animal animal);
    public List<Animal> showAllAnimals();
    public List<Animal> showSickAnimals();
    public Animal getAnimalById(int animalId);
    public void addZone(Zone zone);
    // TODO add local service for deleteAnimalFromFreezer()
    // TODO add local service for insertToFreezer()
}
