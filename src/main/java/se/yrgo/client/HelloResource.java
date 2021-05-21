package se.yrgo.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/fantastic-world")
public class HelloResource {

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World! I'M HOME";
    }
}