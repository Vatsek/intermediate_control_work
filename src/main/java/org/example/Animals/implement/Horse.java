package org.example.Animals.implement;

import org.example.Animals.AbstractWorkingAnimal;
import org.example.Animals.TypeOfAnimal;

import java.time.LocalDate;

public class Horse extends AbstractWorkingAnimal {
    public Horse(String name, LocalDate birthDate) {
        super(name, birthDate);
        setTypeOfAnimal(org.example.Animals.TypeOfAnimal.HORSE);
    }
}
