package se.yrgo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Henrik
 * @mobprogrammers Lukas, Helena, Rasmus
 */
@Entity
public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String name;

    @OneToMany(targetEntity = Animal.class)
    @JoinColumn(name = "Zone_FK")
    @Getter
    @Setter
    private List<Animal> listOfAnimals;

    public Zone() {
    }

    public Zone(String name) {
        this.name = name;
        this.listOfAnimals = new ArrayList();
    }

    public void addAnimals(Animal animal) {
        this.listOfAnimals.add(animal);
    }

    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
