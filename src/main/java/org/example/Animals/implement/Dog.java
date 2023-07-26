package org.example.Animals.implement;
import org.example.Animals.AbstractPet;
import java.time.LocalDate;

public class Dog extends AbstractPet {
    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
        setTypeOfAnimal(org.example.Animals.TypeOfAnimal.DOG);
    }
}
