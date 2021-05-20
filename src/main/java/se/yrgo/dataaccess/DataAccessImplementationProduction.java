package se.yrgo.dataaccess;

import se.yrgo.domain.Animal;
import se.yrgo.domain.Employee;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Default
public class DataAccessImplementationProduction implements DataAccess {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void deleteAnimal(int animalId) {
       Animal toKill = em.find(Animal.class, animalId);
        em.remove(toKill);

    }

    @Override
    public void deleteAnimalFromFreezer(Animal animal) {

    }

    @Override
    public void insertToFreezer(Animal animal) {

    }

    @Override
    public void insertAnimal(Animal animal) {
        em.persist(animal);
    }

    @Override
    public List<Animal> findAllAnimals() {
        return em.createQuery("SELECT animal FROM Animal animal").getResultList();

    }

    @Override
    public List<Animal> findSickAnimals() {
        return em.createQuery("SELECT animal FROM Animal animal WHERE animal.healthStatus = 'sick'").getResultList();
    }

    @Override
    public Animal findAnimalById(int animalId) {
        return em.find(Animal.class, animalId);
    }
}
