package se.yrgo.service;

import se.yrgo.dataaccess.AnimalNotFoundException;
import se.yrgo.dataaccess.HealthNotUpdatedException;
import se.yrgo.domain.Animal;
import se.yrgo.domain.HealthStatus;
import se.yrgo.domain.Zone;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ZooService {
    public void executeAnimal(int animalId) throws AnimalNotFoundException;
    public void removeAnimalFromFreezer(Animal animal);
    public void putInFreezer(Animal animal);
    public void buyAnimal(Animal animal);
    public List<Animal> showAllAnimals();
    public List<Animal> showSickAnimals();
    public Animal getAnimalById(int animalId) throws AnimalNotFoundException;
    public void addZone(Zone zone);
    public Animal updateAnimalHealth(int animalId, int status) throws HealthNotUpdatedException;

    void addAnimalToZone(int animalId, int zoneId);
    // TODO add service for deleteAnimalFromFreezer()
    // TODO add service for insertToFreezer()
}
