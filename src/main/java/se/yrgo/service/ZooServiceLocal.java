package se.yrgo.service;

import se.yrgo.dataaccess.AnimalNotFoundException;
import se.yrgo.dataaccess.HealthNotUpdatedException;
import se.yrgo.domain.Animal;
import se.yrgo.domain.HealthStatus;
import se.yrgo.domain.Zone;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ZooServiceLocal {
    public void executeAnimal(int animalId) throws AnimalNotFoundException;
    public void removeAnimalFromFreezer(Animal animal);
    public void putInFreezer(int animalid) throws AnimalNotFoundException;
    public void buyAnimal(Animal animal);
    public List<Animal> showAllAnimals();
    public List<Animal> showSickAnimals();
    public Animal getAnimalById(int animalId) throws AnimalNotFoundException;
    public void addZone(Zone zone);
    public void updateAnimalHealth(int animalId, HealthStatus status) throws HealthNotUpdatedException;

    void addAnimalToZone(int animalId, int zoneId);
    // TODO add local service for deleteAnimalFromFreezer()
    // TODO add local service for insertToFreezer()
}
