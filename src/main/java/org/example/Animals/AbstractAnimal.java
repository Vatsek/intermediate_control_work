package org.example.Animals;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.example.Animals.TypeOfAnimal.NOT_DEFINED;

public abstract class AbstractAnimal {

    private static int count;
    private final int id = ++count;

    private String name;
    private LocalDate birthDate;
    private TypeOfAnimal typeOfAnimal = NOT_DEFINED;

    private ArrayList<String> skill = new ArrayList<>();

    public AbstractAnimal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {

        return id;
    }
    public void setTypeOfAnimal(org.example.Animals.TypeOfAnimal typeOfAnimal) {

        this.typeOfAnimal = typeOfAnimal;
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

    public void getSkill() {
        System.out.println("\nКоманды животного:");
        for (String skill: skill) {
            System.out.print(skill + " | ");
        }
        System.out.println();
    }

    public void setSkill(String skill) {
        this.skill.add(skill);
    }

    @Override
    public String toString() {
        StringBuilder skills = new StringBuilder();
        for (String str: this.skill) {
            skills.append(str + " ");
        }
        return ("id: " + this.id + " | Имя: " + this.name + " | Класс животного: " + this.typeOfAnimal.getTitle() + " | Команды: " + skills);
    }
}
