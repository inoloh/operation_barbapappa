package se.yrgo.client;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

// Detta ersätter /webservices/* som vi tidigare haft i web.xml
// Alla Paths i HelloRecourse börjar med url:en nedan,  /fantastic-world
@ApplicationPath("/fantastic-world")
public class HelloApplication extends Application {


}