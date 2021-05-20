package se.yrgo.service;

import se.yrgo.dataaccess.DataAccess;
import se.yrgo.domain.Animal;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ZooServiceImpl implements ZooService {

    @Inject
    private DataAccess dao;

    @Override
    public void executeAnimal(Animal animal) {

    }

    @Override
    public void emptyFreezer() {

    }

    @Override
    public void putInFreezer(Animal animal) {

    }

    @Override
    public void buyAnimal() {

    }

    @Override
    public List<Animal> showAllAnimals() {
        return null;
    }

    @Override
    public List<Animal> showSickAnimals() {
        return null;
    }
}
