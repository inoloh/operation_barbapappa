package se.yrgo.client;

import se.yrgo.dataaccess.AnimalNotFoundException;
import se.yrgo.domain.Animal;
import se.yrgo.service.ZooService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.Properties;

/**
 * @author Helena
 * @mobprogrammers Rasmus, Lukas, Henrik
 */
public class Main {
    public static void main(String[] args) throws NamingException, AnimalNotFoundException {
        Properties jndiProperties = new Properties();

        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        jndiProperties.put(Context.SECURITY_AUTHENTICATION, "simple");
        jndiProperties.put(Context.SECURITY_PRINCIPAL, "appuser2");
        jndiProperties.put(Context.SECURITY_CREDENTIALS, "password2!");
        System.out.println(jndiProperties);

        Context jndi = new InitialContext(jndiProperties);
        ZooService service = (ZooService) jndi.lookup("operation_barbapappa-1.0-SNAPSHOT-war/ZooServiceImpl!se.yrgo.service.ZooService");


//        Animal jeff = new Animal("Jeff", 4, "Hawaiian monk seal", HealthStatus.SICK, "1984-04-12");
//        Animal nigel = new Animal("Nigel", 4, "Hawaiian monk seal", HealthStatus.HEALTHY, "1984-04-12");
//        Animal esteban = new Animal("Esteban", 4, "Hawaiian monk seal", HealthStatus.SICK, "1984-04-12");

        List<Animal> allAnimals = service.showAllAnimals();

        System.out.println("All animals:");
        for (Animal animal : allAnimals) {
            System.out.println(animal);
        }

//        service.buyAnimal(jeff);
//        service.buyAnimal(nigel);
//        service.buyAnimal(esteban);



//        List<Animal> sickAnimals = service.showSickAnimals();

//        System.out.println("All the sick animals:");
//        for (Animal animal : sickAnimals) {
//            System.out.println(animal);
//        }



    }
}

