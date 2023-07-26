package org.example.Animals.implement;

import org.example.Animals.AbstractPet;

import java.time.LocalDate;

public class Cat extends AbstractPet {
    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
        setTypeOfAnimal(org.example.Animals.TypeOfAnimal.CAT);
    }
}
