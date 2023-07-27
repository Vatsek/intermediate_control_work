package org.example.db;

import org.example.Animals.AbstractAnimal;

import java.util.HashMap;
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

    public static void showSkillAnimals(){
        showAllAnimals();
        System.out.print("\nВведите id животного, чьи команды хотите просмотреть: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        db.get(id).getSkill();
    }

    public static void setSkillAnimal(){
        showAllAnimals();
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.print("\nВведите id животного, которому хотите добавить команды: ");
        int id = sc.nextInt();
        System.out.print("Введите команду, которую хотите добавить: ");
        String skill = sc2.nextLine();
        db.get(id).setSkill(skill);
        System.out.println("\nКоманда успешно добавлена");
    }

}

