package org.example.Animals.implement;

import org.example.Animals.AbstractPet;
import org.example.Animals.TypeOfAnimal;

import java.time.LocalDate;

public class Hamster extends AbstractPet {
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
        setTypeOfAnimal(org.example.Animals.TypeOfAnimal.HAMSTER);
    }
}
