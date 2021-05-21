package se.yrgo.client;

import se.yrgo.domain.Animal;
import se.yrgo.service.ZooServiceLocal;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

// Finns på denna URL: http://localhost:8080/operation_barbapappa-1.0-SNAPSHOT-war/fantastic-world/animals
@Path("/animals")
@Stateless
public class ZooResource {

    @Inject
    private ZooServiceLocal service;

    @GET
    @Produces("application/JSON")
    public List<Animal> getAllAnimals() {
    //TODO Change type to Response, add errorhandling
        return service.showAllAnimals();
    }

    @GET
    @Produces("application/JSON")
    @Path("{animalId}")
    public Animal getById(@PathParam("animalId") int id) {
        //TODO Change type to Response, add errorhandling
        return service.getAnimalById(id);
    }

    @GET
    @Produces("application/JSON")
    @Path("/sick")
    public List<Animal> getAllSickAnimals() {
        //TODO Change type to Response, add errorhandling
        return service.showSickAnimals();
    }


    // TODO implement executeAnimal(int animalId);
    // TODO implement public void removeAnimalFromFreezer(Animal animal);
    // TODO implement public void putInFreezer(Animal animal);
    // TODO implement public void buyAnimal(Animal animal);
    // TODO implement public void addZone(Zone zone);

}