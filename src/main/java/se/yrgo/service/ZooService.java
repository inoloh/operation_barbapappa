package se.yrgo.service;

import se.yrgo.domain.Animal;
import se.yrgo.domain.Zone;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ZooService {
    public void executeAnimal(int animalId);
    public void removeAnimalFromFreezer(Animal animal);
    public void putInFreezer(int animalId);
    public void buyAnimal(Animal animal);
    public List<Animal> showAllAnimals();
    public List<Animal> showSickAnimals();
    public Animal getAnimalById(int animalId);
    public void addZone(Zone zone);
    // TODO add service for deleteAnimalFromFreezer()
    // TODO add service for insertToFreezer()
}
