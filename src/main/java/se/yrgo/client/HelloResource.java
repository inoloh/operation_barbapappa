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

@Path("/animals")
@Stateless
public class HelloResource {

    @Inject
    private ZooServiceLocal service;


//    @GET
//    @Produces("text/plain")
//    public String hello() {
//        return "Welcome to Fantastic World!";
//    }

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