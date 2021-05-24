package se.yrgo.dataaccess;

import se.yrgo.domain.Animal;
import se.yrgo.domain.HealthStatus;
import se.yrgo.domain.Zone;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Implements the DataAccess interface and communicates directly with the database.
 * @author Helena
 * @mobprogrammers Henrik, Rasmus, Lukas
 */
@Stateless
@Default
public class DataAccessImplementationProduction implements DataAccess {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void deleteAnimal(int animalId) throws AnimalNotFoundException {
        int successfulDelete = em.createQuery("delete from Animal animal where animal.id = :id")
                .setParameter("id", animalId).executeUpdate();
        if (successfulDelete == 0) {
            throw new AnimalNotFoundException();
        }

    }

    @Override
    public void insertAnimal(Animal animal) throws AnimalNotFoundException {
        try {
        em.persist(animal);
        } catch (NoResultException ex) {
        throw new AnimalNotFoundException();
    }
    }

    @Override
    public List<Animal> findAllAnimals() throws AnimalNotFoundException {
        try {
        return em.createQuery("SELECT animal FROM Animal animal").getResultList();

        } catch (NoResultException ex) {
            throw new AnimalNotFoundException();
        }
    }

    @Override
    public List<Animal> findSickAnimals() throws AnimalNotFoundException {
        try {
        return em.createQuery("SELECT animal FROM Animal animal WHERE animal.healthStatus = 1").getResultList();
        } catch (NoResultException ex) {
            throw new AnimalNotFoundException();
        }
    }

    @Override
    public Animal findAnimalById(int animalId) throws AnimalNotFoundException {
        try {
            Query q = em.createQuery("select animal from Animal animal where animal.id = :id");
            q.setParameter("id", animalId);
            return (Animal) q.getSingleResult();
        } catch (NoResultException ex) {
            throw new AnimalNotFoundException();
        }
    }

    @Override
    public void updateHealthstatus(int animalid, HealthStatus status) throws HealthNotUpdatedException {
        try {
            Animal animal = findAnimalById(animalid);
            animal.setHealthStatus(status);

        } catch (AnimalNotFoundException ex) {
            throw new HealthNotUpdatedException();
        }

    }

}
