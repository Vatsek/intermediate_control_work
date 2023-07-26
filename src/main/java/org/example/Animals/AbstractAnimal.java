package org.example.Animals;

import java.time.LocalDate;

public abstract class AbstractAnimal {

    private static int counter;
    private final int id = ++counter;

    private org.example.Animals.TypeOfAnimal TypeOfAnimal;
    private String name;
    private LocalDate birthDate;

    public AbstractAnimal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }


    public int getId() {
        return id;
    }

    public org.example.Animals.TypeOfAnimal getTypeOfAnimal() {
        return TypeOfAnimal;
    }

    public void setTypeOfAnimal(org.example.Animals.TypeOfAnimal typeOfAnimal) {
        TypeOfAnimal = typeOfAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
