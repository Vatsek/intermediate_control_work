package org.example;

import org.example.Animals.AbstractAnimal;
import org.example.Animals.implement.Cat;
import org.example.Animals.implement.Dog;
import org.example.Comands.MenuComands;
import org.example.Menu.Menu;
import org.example.db.Db;
import java.time.LocalDate;
import java.util.Scanner;

public class Program {

    public static void run() throws Exception {
        Scanner sc = new Scanner(System.in);
        Menu mn = new Menu();
        MenuComands mc = new MenuComands();
        AbstractAnimal cat1 = new Cat("Васька", LocalDate.of(2020, 02,02));
        AbstractAnimal cat2 = new Cat("Жорка", LocalDate.of(2018, 01,10));
        AbstractAnimal dog1 = new Dog("Полкан", LocalDate.of(2010, 10,10));
        Db.db.put(cat1.getId(), cat1);
        Db.db.put(cat2.getId(), cat2);
        Db.db.put(dog1.getId(), dog1);
        cat2.setSkill("Брысь");
        cat2.setSkill("Спи");
        dog1.setSkill("Апорт");
        dog1.setSkill("Фас");
        dog1.setSkill("Рядом");


        while (true) {
            try {
            System.out.println("\nСписок команд:");
            mn.showMainMenu();
            System.out.print("\nВведите номер команды: ");
            String comand = sc.nextLine();
            switch (comand) {
                case "1":
                    Db.showAllAnimals();
                    break;
                case "2":
                    mc.addAnimal();
                    break;
                case "3":
                    Db.showSkillAnimals();
                     break;
                case "4":
                    Db.setSkillAnimal();
                    break;
                case "5": break;
                default:
                    System.out.println("\nНе верно введён номер команды\n");
            }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }



    }
}
