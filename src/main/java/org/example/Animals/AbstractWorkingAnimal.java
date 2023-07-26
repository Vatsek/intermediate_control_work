package org.example.Animals;

import java.time.LocalDate;

public abstract class AbstractWorkingAnimal extends AbstractAnimal {

    public AbstractWorkingAnimal(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
