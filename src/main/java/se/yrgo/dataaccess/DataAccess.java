package se.yrgo.dataaccess;

import se.yrgo.domain.Animal;
import se.yrgo.domain.HealthStatus;
import se.yrgo.domain.Zone;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DataAccess {
    public void deleteAnimal(int animalId) throws AnimalNotFoundException;
    public void insertAnimal(Animal animal) throws AnimalNotFoundException;
    public List<Animal> findAllAnimals() throws AnimalNotFoundException;
    public List<Animal> findSickAnimals() throws AnimalNotFoundException;
    public Animal findAnimalById(int animalId) throws AnimalNotFoundException;
    public void updateHealthstatus(int animalId, HealthStatus status) throws HealthNotUpdatedException;

}
