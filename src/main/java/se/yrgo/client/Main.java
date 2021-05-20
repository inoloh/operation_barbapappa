package se.yrgo.client;

import se.yrgo.domain.Animal;
import se.yrgo.domain.Employee;
import se.yrgo.service.ZooService;
import se.yrgo.service.ZooServiceImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.Properties;


public class Main {
    public static void main(String[] args) throws NamingException {
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


//        service.buyAnimal(new Animal("Jeff", 4, "Hawaiian monk seal", "sick", "1984-04-12"));
//        service.buyAnimal(new Animal("Nigel", 4, "Hawaiian monk seal", "healthy AF", "1984-04-12"));
//        service.buyAnimal(new Animal("Esteban", 4, "Hawaiian monk seal", "sick", "1984-04-12"));
//        Animal animal = service.getAnimalById(2);
//        System.out.println("alive");
//        System.out.println(animal);
        service.executeAnimal(3);
 //       service.executeAnimal(5);
//        System.out.println("dead");

            List<Animal>sickAnimals = service.showSickAnimals();


//        List<Animal> allAnimals = service.showAllAnimals();
        for (Animal animal : sickAnimals) {
            System.out.println(animal);
        }
//        List<Animal> ListOfAnimals = service.showAllAnimals();
//
//        System.out.println(ListOfAnimals);

    }
}

