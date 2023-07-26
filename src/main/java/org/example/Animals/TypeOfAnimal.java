package org.example.Animals;

public enum TypeOfAnimal {

    DOG ("Собака"),
    CAT ("Кошка"),
    HAMSTER ("Хомяк"),
    HORSE ("Лошадь"),
    CAMEL ("Верблюд"),
    DONKEY ("Осёл");

    private String title;
    TypeOfAnimal(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
