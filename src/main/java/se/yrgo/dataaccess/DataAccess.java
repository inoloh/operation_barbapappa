package se.yrgo.dataaccess;

import se.yrgo.domain.Animal;
import se.yrgo.domain.HealthStatus;
import se.yrgo.domain.Zone;

import javax.ejb.Local;
import java.util.List;

/** Data access layer
 * Contains methods that communicates directly with the database
 * @author Henrik
 * @mobprogrammers Helena, Rasmus, Lukas
 */
@Local
public interface DataAccess {

    /**
     * Deletes an animal from the database.
     *
     * @param animalId the id of the animal to delete
     * @throws AnimalNotFoundException if animal is not found in database
     */
    public void deleteAnimal(int animalId) throws AnimalNotFoundException;

    /**
     *
     * @param animal object to insert into database
     * @throws AnimalNotFoundException if animal is not found in database
     */
    public void insertAnimal(Animal animal) throws AnimalNotFoundException;

    /**
     *
     * @return a list of all animals in the database
     * @throws AnimalNotFoundException if animal is not found in database
     */
    public List<Animal> findAllAnimals() throws AnimalNotFoundException;

    /**
     *
     * @return a list of all sick animals in the database
     * @throws AnimalNotFoundException if animal is not found in database
     */
    public List<Animal> findSickAnimals() throws AnimalNotFoundException;

    /**
     *
     * @param animalId the id of the animal to find
     * @return an animal
     * @throws AnimalNotFoundException if animal is not found in database
     */
    public Animal findAnimalById(int animalId) throws AnimalNotFoundException;

    /**
     *
     * @param animalId the id of the animal to update healthstatus on
     * @param status the healthstatus to set
     * @throws HealthNotUpdatedException if animal is not found in database
     */
    public void updateHealthstatus(int animalId, HealthStatus status) throws HealthNotUpdatedException;

}
