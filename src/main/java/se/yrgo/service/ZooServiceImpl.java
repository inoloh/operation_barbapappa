package se.yrgo.service;

import se.yrgo.dataaccess.AnimalNotFoundException;
import se.yrgo.dataaccess.DataAccess;

import se.yrgo.dataaccess.HealthNotUpdatedException;
import se.yrgo.domain.Animal;
import se.yrgo.domain.HealthStatus;

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
    public void buyAnimal(Animal animal) throws AnimalNotFoundException {
    dao.insertAnimal(animal);
    }

    @Override
    public List<Animal> showAllAnimals() throws AnimalNotFoundException { return dao.findAllAnimals(); }

    @Override
    public List<Animal> showSickAnimals() throws AnimalNotFoundException {
        return dao.findSickAnimals();
    }

    @Override
    public Animal getAnimalById(int animalId) throws AnimalNotFoundException {
        return dao.findAnimalById(animalId);
    }

    @Override
    public void updateAnimalHealth(int animalId, HealthStatus status) throws HealthNotUpdatedException {
        dao.updateHealthstatus(animalId, status);
    }

}
