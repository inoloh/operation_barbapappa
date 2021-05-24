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
    public Response getAllAnimals() {
        try {
            List<Animal> result = service.showAllAnimals();
            return Response.ok(result).build();
        } catch (AnimalNotFoundException ex) {
            return Response.status(404).build();
        }
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
    public Response getAllSickAnimals() {
        try {
            List<Animal> result = service.showSickAnimals();
            return Response.ok(result).build();
        } catch (AnimalNotFoundException ex) {
            return Response.status(404).build();
        }
    }

    @POST
    @Produces("application/JSON")
    @Consumes("application/JSON")
    public Response buyAnimal(Animal animal) {
        try {
            service.buyAnimal(animal);
            return Response.ok().build();
        } catch (AnimalNotFoundException ex) {
            return Response.status(404).build();
        }
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

    @PUT
    @Path("/updatehealth")
    @Produces("application/JSON")
    @Consumes("application/JSON")
    public Response updateHealth(@QueryParam("animalid") int id, @QueryParam("status") HealthStatus status) {
        try {
            if (id == 0 || status == null) {
                return Response.status(404).build();
            }
            service.updateAnimalHealth(id, status);
            return Response.ok().build();
        } catch (HealthNotUpdatedException ex) {
            return Response.status(404).build();
        }
    }


}