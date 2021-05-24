package se.yrgo.client;

import se.yrgo.dataaccess.AnimalNotFoundException;
import se.yrgo.dataaccess.HealthNotUpdatedException;
import se.yrgo.domain.Animal;
import se.yrgo.domain.HealthStatus;
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

    //TODO Change type to Response, add errorhandling
    @GET
    @Produces("application/JSON")
    public List<Animal> getAllAnimals() {
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

    //TODO Change type to Response, add errorhandling
    @GET
    @Produces("application/JSON")
    @Path("/sick")
    public List<Animal> getAllSickAnimals() {
        return service.showSickAnimals();
    }

    @POST
    @Produces("application/JSON")
    @Consumes("application/JSON")
    public Animal buyAnimal(Animal animal) {
        // TODO response erroehandlervbgd
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

    // TODO lite större felhantering a la nahid workshop
    @PUT
    @Produces("application/JSON")
    @Consumes("application/JSON")
    public Response updateHealth(@QueryParam("animalid") int id, @QueryParam("status") HealthStatus status) {
        try {
            service.updateAnimalHealth(id, status);
            return Response.ok().build();
        } catch (HealthNotUpdatedException ex) {
            return Response.status(404).build();
        }
    }



}