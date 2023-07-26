package org.example.Animals.implement;

import org.example.Animals.AbstractWorkingAnimal;
import org.example.Animals.TypeOfAnimal;

import java.time.LocalDate;

public class Donkey extends AbstractWorkingAnimal {
    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
        setTypeOfAnimal(TypeOfAnimal.DONKEY);
    }
}
