package se.yrgo.client;

import se.yrgo.dataaccess.AnimalNotFoundException;
import se.yrgo.domain.Animal;
import se.yrgo.service.ZooServiceLocal;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
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
    public Response getById(@PathParam("animalId") int id) {
        try {
            Animal result = service.getAnimalById(id);
            return Response.ok(result).build();
        } catch (AnimalNotFoundException ex) {
            return Response.status(404).build();
        }
    }

    @GET
    @Produces("application/JSON")
    @Path("/sick")
    public List<Animal> getAllSickAnimals() {
        //TODO Change type to Response, add errorhandling
        return service.showSickAnimals();
    }

    @POST
    @Produces("application/JSON")
    @Consumes("application/JSON")
    public Animal buyAnimal(Animal animal) {
        service.buyAnimal(animal);
        return animal;
    }

    @DELETE
    @Path("/execute/{animalId}")
    public Response executeAnimal(@PathParam("animalId") int id) {
        try {
            service.executeAnimal(id);
            return Response.ok().build();
        } catch (AnimalNotFoundException ex) {
            return Response.status(404).build();
        }
    }


    // TODO implement public void removeAnimalFromFreezer(Animal animal);
    // TODO implement public void putInFreezer(Animal animal);
    // TODO implement public void addZone(Zone zone);

}