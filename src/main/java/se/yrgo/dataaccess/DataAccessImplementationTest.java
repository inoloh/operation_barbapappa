package se.yrgo.dataaccess;

import se.yrgo.domain.Animal;
import se.yrgo.domain.HealthStatus;
import se.yrgo.domain.Zone;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import java.util.*;

/**
 * Implements the DataAccess interface but does not communicate with the database,
 * uses java objects to test logic.
 * @author Rasmus
 * @mobprogrammers Henrik, Helena, Lukas
 */
@Stateless
@Alternative
public class DataAccessImplementationTest implements DataAccess {

    @Override
    public void deleteAnimal(int animalId) throws AnimalNotFoundException {
    }

    @Override
    public void insertAnimal(Animal animal) {

    }

    @Override
    public List<Animal> findAllAnimals() {
        List<Animal> theAnimals = new ArrayList<>();
        Zone freezer = new Zone("Freezer");
        Zone forest = new Zone("Forest");
        theAnimals.add(new Animal("Bubba", 3, "Sulphur-Crested Cockatoo", HealthStatus.HEALTHY, "2019-04-12"));
        theAnimals.add(new Animal("Helena", 3, "Shaggy Bird", HealthStatus.HEALTHY, "2019-04-12"));
        theAnimals.add(new Animal("Henke", 3, "Mediterranean monk seal", HealthStatus.SICK, "2019-04-12"));

        return theAnimals;
    }

    @Override
    public List<Animal> findSickAnimals() {
        return null;
    }

    @Override
    public Animal findAnimalById(int animalId) throws AnimalNotFoundException {
        return null;
    }

    @Override
    public void updateHealthstatus(int animalId, HealthStatus status) throws HealthNotUpdatedException {
    }

}
