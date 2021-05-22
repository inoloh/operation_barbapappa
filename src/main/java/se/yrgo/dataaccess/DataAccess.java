package se.yrgo.dataaccess;

import se.yrgo.domain.Animal;
import se.yrgo.domain.Zone;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DataAccess {
    public void deleteAnimal(int animalId);
    public void deleteAnimalFromFreezer(Animal animal);
    public void insertToFreezer(int animalId);
    public void insertAnimal(Animal animal);
    public List<Animal> findAllAnimals();
    public List<Animal> findSickAnimals();
    public Animal findAnimalById(int animalId) throws AnimalNotFoundException;
    public void insertZone(Zone zone);
    public void insertAnimalToZone(int animalId,int zoneId);

}
