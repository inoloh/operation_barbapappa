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
    /** Execute and removes an specific animal.
     *
     * @param animalId specified id of the animal.
     * @throws AnimalNotFoundException if no animal was found with the @param animalId.
     */
    public void executeAnimal(int animalId) throws AnimalNotFoundException;
    /** Buys an animal to the Zoo
     *
     * @param animal it takes an animal to buy an animal.
     */
    public void buyAnimal(Animal animal) throws AnimalNotFoundException;
    /** All the animals at the Zoo.
     *
     * @return a list of all the Animals at the Zoo.
     */
    public List<Animal> showAllAnimals() throws AnimalNotFoundException;
    /** All the sick animals at the Zoo.
     *
     * @return a list of all the sick Animals at the Zoo.
     */
    public List<Animal> showSickAnimals() throws AnimalNotFoundException;
    /** Gets an specific animal by id.
     *
     * @param animalId specified id of the animal.
     * @return a animal.
     * @throws AnimalNotFoundException if no animal was found with the @param animalId.
     */
    public Animal getAnimalById(int animalId) throws AnimalNotFoundException;
    /** Change the health status of a specific animal.
     *
     * @param animalId specified id of the animal.
     * @param status specified new health status of the animal (HEALTHY,SICK OR DEAD)
     * @throws HealthNotUpdatedException if health status is not changed from previous status.
     */
    public void updateAnimalHealth(int animalId, HealthStatus status) throws HealthNotUpdatedException;

}
