package se.yrgo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/** This is a animal class
 *
 */
@Entity
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private int age;
    @Getter @Setter private String species;
    @Getter @Setter private HealthStatus healthStatus;
    @Getter @Setter private String purchaseDate;

    public Animal(String name, int age, String species, HealthStatus healthStatus, String purchaseDate) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.healthStatus = healthStatus;
        this.purchaseDate = purchaseDate;
    }

    public Animal(){

    };

    public Animal(int id, String name, int age, String species, HealthStatus healthStatus, String purchaseDate, Zone zone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.species = species;
        this.healthStatus = healthStatus;
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", species='" + species + '\'' +
                ", healthStatus=" + healthStatus.name().toLowerCase() +
                ", purchaseDate='" + purchaseDate + '\'' +
                '}';
    }
}
