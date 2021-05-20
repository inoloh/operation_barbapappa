package se.yrgo.dataaccess;

import se.yrgo.domain.Animal;
import se.yrgo.domain.Employee;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Alternative
public class DataAccessImplementation implements DataAccess {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void deleteAnimal(Animal animal) {

    }

    @Override
    public void deleteAnimalFromFreezer(Animal animal) {

    }

    @Override
    public void insertToFreezer(Animal animal) {

    }

    @Override
    public void insertAnimal(Animal animal) {

    }

    @Override
    public List<Animal> findAllAnimals() {
        List<Animal> theAnimals = new ArrayList<>();
        theAnimals.add(new Animal("Bubba",3,"Sulphur-Crested Cockatoo","fine","2019-04-12"));
        theAnimals.add(new Animal("Helena",3,"Shaggy Bird","fine","2019-04-12"));
        theAnimals.add(new Animal("Henke",3,"Mediterranean monk seal","fine","2019-04-12"));
        theAnimals.add(new Animal("Lukas",3,"Laptev Walrus","fine","2019-04-12"));
        theAnimals.add(new Animal("Rasmus",3,"Sulphur-Crested Cockatoo","fine","2019-04-12"));

        return theAnimals;
    }

    @Override
    public List<Animal> findSickAnimals() {
        return null;
    }
}
