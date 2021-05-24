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

@Stateless
@Default
public class DataAccessImplementationProduction implements DataAccess {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void deleteAnimal(int animalId) throws AnimalNotFoundException {
        // fick ändra lite för kodernas skull
        int successfulDelete = em.createQuery("delete from Animal animal where animal.id = :id")
                    .setParameter("id", animalId).executeUpdate();
        if (successfulDelete == 0) {
            throw new AnimalNotFoundException();
        }


       /*Animal toKill = em.find(Animal.class, animalId);
       em.remove(toKill);*/
    }

    @Override
    public void deleteAnimalFromFreezer(Animal animal) {
    // TODO implement deleteAnimalFromFreezer
    }

    @Override
    public void insertToFreezer(Animal animal) {

        // TODO försökte något här som inte heller funkade :(
        Zone freezer = em.find(Zone.class, 26);
        /*Animal animal = em.find(Animal.class, animalId);*/
        freezer.addAnimals(animal);
        em.persist(freezer);

        //TODO Detta funkar sådär
        // Funkar bara om vi anger rätt id för frysen, den ändras hela tiden...
        /*Zone freez = em.find(Zone.class,24);
        Animal animal = em.find(Animal.class, animalId);
        em.createQuery("DELETE from Zone zone where zone.listOfAnimalId = :Id ").setParameter("Id",animalId);
        freez.addAnimals(animal);
        em.persist(freez);*/

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
        return em.createQuery("SELECT animal FROM Animal animal WHERE animal.healthStatus = 1").getResultList();
    }

    @Override
    public Animal findAnimalById(int animalId) throws AnimalNotFoundException {
        try {
            // var tvungen att ändra här för att få rätt 404 kod att funka, med find blir allt 200..
            Query q = em.createQuery("select animal from Animal animal where animal.id = :id");
            q.setParameter("id", animalId);
            return (Animal) q.getSingleResult();
            /*return em.find(Animal.class, animalId);*/
        } catch (NoResultException ex) {
            throw new AnimalNotFoundException();
        }
    }

    @Override
    public void insertZone(Zone zone) {
        em.persist(zone);
    }

    @Override
    public void insertAnimalToZone(int animalId, int zoneId) {
        Animal animal = em.find(Animal.class, animalId);
        Zone zon = em.find(Zone.class,zoneId);
        zon.addAnimals(animal);
        em.persist(zon);
    }

    // TODO fungerar ej som den ska
    @Override
    public void updateHealthstatus(int animalid, HealthStatus status) throws HealthNotUpdatedException {
        try {
        Animal animal = findAnimalById(animalid);
        animal.setHealthStatus(status);

        } catch (AnimalNotFoundException ex) {
            throw new HealthNotUpdatedException();
        }
        /*Query q = em.createQuery("update Animal animal set animal.healthStatus = :status where animal.id = :id");
        q.setParameter("status", status);
        q.setParameter("id", animalid);*/
        /*int update = q.executeUpdate();*/

        /*if (update == 0) {
            throw new HealthNotUpdatedException();
        } else {
            Query select = em.createQuery("select animal from Animal animal where animal.id = :id");
            select.setParameter("id", animalid);
            return (Animal) select.getSingleResult();
        }*/


       // TODO lägg till felhantering här
    }

}
