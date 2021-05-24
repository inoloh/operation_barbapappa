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
    public void buyAnimal(Animal animal) throws AnimalNotFoundException;
    public List<Animal> showAllAnimals() throws AnimalNotFoundException;
    public List<Animal> showSickAnimals() throws AnimalNotFoundException;
    public Animal getAnimalById(int animalId) throws AnimalNotFoundException;
    public void updateAnimalHealth(int animalId, HealthStatus status) throws HealthNotUpdatedException;

}
