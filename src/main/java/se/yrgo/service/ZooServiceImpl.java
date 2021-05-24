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

    /** Execute and removes an specific animal.
     *
     * @param animalId specified id of the animal.
     * @throws AnimalNotFoundException if no animal was found with the @param animalId.
     */
    @Override
    public void executeAnimal(int animalId) throws AnimalNotFoundException {
        dao.deleteAnimal(animalId);
    }

    @Override
    public void buyAnimal(Animal animal) throws AnimalNotFoundException {
    public void removeAnimalFromFreezer(Animal animal) {

    }

    @Override
    public void putInFreezer(Animal animal) {
        dao.insertToFreezer(animal);
    }

    /** Buys an animal to the Zoo
     *
     * @param animal it takes an animal to buy an animal.
     */
    @Override
    public void buyAnimal(Animal animal) {
    dao.insertAnimal(animal);
    }

    /** All the animals at the Zoo.
     *
     * @return a list of all the Animals at the Zoo.
     */
    @Override
    public List<Animal> showAllAnimals() throws AnimalNotFoundException { return dao.findAllAnimals(); }

    /** All the sick animals at the Zoo.
     *
     * @return a list of all the sick Animals at the Zoo.
     */
    @Override
    public List<Animal> showSickAnimals() throws AnimalNotFoundException {
        return dao.findSickAnimals();
    }

    /** Gets an specific animal by id.
     *
     * @param animalId specified id of the animal.
     * @return a animal.
     * @throws AnimalNotFoundException if no animal was found with the @param animalId.
     */
    @Override
    public Animal getAnimalById(int animalId) throws AnimalNotFoundException {
        return dao.findAnimalById(animalId);
    }

    @Override
    public void addZone(Zone zone) { dao.insertZone(zone); }

    /** Change the health status of a specific animal.
     *
     * @param animalId specified id of the animal.
     * @param status specified new health status of the animal (HEALTHY,SICK OR DEAD)
     * @throws HealthNotUpdatedException if health status is not changed from previous status.
     */
    @Override
    public void updateAnimalHealth(int animalId, HealthStatus status) throws HealthNotUpdatedException {
        dao.updateHealthstatus(animalId, status);
    }

}
