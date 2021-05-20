package se.yrgo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private int id;
    @Getter @Setter private String name;
    @Getter @Setter private String age;
    @Getter @Setter private String species;
    @Getter @Setter private String healthStatus;
    @Getter @Setter private LocalDateTime purchaseDate;

    public Animal(String name, String age, String species, String healthStatus, LocalDateTime purchaseDate) {
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
                ", age='" + age + '\'' +
                ", species=" + species +
                ", healthStatus=" + healthStatus +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
