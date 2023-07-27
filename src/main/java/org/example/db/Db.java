package org.example.db;

import org.example.Animals.AbstractAnimal;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Db {

    public static Map<Integer, AbstractAnimal> db = new HashMap<>();

    public static void showAllAnimals() {
        System.out.print("\n");
        if (db.size() != 0) {
            System.out.println("Список всех животных:");
            for (int i = 0; i < db.size(); i++) {
                System.out.println(db.get(i + 1).toString());
            }
        }
        else System.out.println("Список животных пуст\n");
    }

    public static void showSkillAnimals() {
        showAllAnimals();
        System.out.print("\nВведите id животного, команды которого хотите посмотреть: ");
        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();
        try {
            int indx = Integer.parseInt(id);
            if (indx > 0 && indx <= db.size()) {
                db.get(indx).getSkill();
            }
            else throw new IndexOutOfBoundsException("Нет животного с таким id");
        } catch (NumberFormatException e){
            System.out.println("Не корректно введён id");
        }

    }

    public static void setSkillAnimal() {
        showAllAnimals();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.print("\nВведите id животного, которому хотите добавить команды: ");
        String id = sc.nextLine();
        try {
            int indx = Integer.parseInt(id);
            if (indx > 0 && indx <= db.size()) {
                System.out.print("Введите команду, которую хотите добавить: ");
                String skill = sc2.nextLine();
                if (skill.isEmpty()){
                    throw new InputMismatchException("Команда не может быть пустой");
                }
                db.get(Integer.parseInt(id)).setSkill(skill);
                System.out.println("\nКоманда успешно добавлена");
            } else throw new InputMismatchException("Нет животного, с таким id");
        } catch (NumberFormatException e) {
            System.out.println("Не корректно введён id");
        }
    }
}

