package se.yrgo.service;

import se.yrgo.dataaccess.AnimalNotFoundException;
import se.yrgo.dataaccess.DataAccess;

import se.yrgo.dataaccess.HealthNotUpdatedException;
import se.yrgo.domain.Animal;
import se.yrgo.domain.HealthStatus;
import se.yrgo.domain.Zone;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ZooServiceImpl implements ZooService, ZooServiceLocal {

    @Inject
    private DataAccess dao;

    @Override
    public void executeAnimal(int animalId) throws AnimalNotFoundException {
        dao.deleteAnimal(animalId);
    }

    @Override
    public void removeAnimalFromFreezer(Animal animal) {

    }

    @Override
    public void putInFreezer(Animal animal) {
        dao.insertToFreezer(animal);
    }

    @Override
    public void buyAnimal(Animal animal) {
    dao.insertAnimal(animal);
    }

    @Override
    public List<Animal> showAllAnimals() { return dao.findAllAnimals(); }

    @Override
    public List<Animal> showSickAnimals() {
        return dao.findSickAnimals();
    }

    @Override
    public Animal getAnimalById(int animalId) throws AnimalNotFoundException {
        return dao.findAnimalById(animalId);
    }

    @Override
    public void addZone(Zone zone) { dao.insertZone(zone); }

    @Override
    public Animal updateAnimalHealth(int animalId, int status) throws HealthNotUpdatedException {
        return dao.updateHealthstatus(animalId, status);
    }

    @Override
    public void addAnimalToZone(int animalId, int zoneId) {
        dao.insertAnimalToZone(animalId, zoneId);
    }
}
