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
        //TODO Change type to Response, add errorhandling - jag tror inte Response? för då ser man ju ingenting?
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

    // TODO funkar icke... por que? HALP, gjort om den till age bara för att se om det var enumet som spökade, men tror det är PUT?
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


    // TODO funkar icke heller, por que maria
    @POST
    @Path("/freezer")
    @Consumes("application/JSON")
    public void putAnimalInFreezer(Animal animal) {
        service.putInFreezer(animal);
    }


    // TODO implement public void removeAnimalFromFreezer(Animal animal);
    // TODO implement public void putInFreezer(Animal animal);
    // TODO implement public void addZone(Zone zone);

}