package org.example.Comands;

import org.example.Animals.AbstractAnimal;
import org.example.Animals.implement.*;
import org.example.Counter;
import org.example.db.Db;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import static org.example.Animals.TypeOfAnimal.*;

public class MenuComands {
    public MenuComands() {
    }

    public boolean addAnimal() throws Exception {
        while (true) {
            Counter counter 1= new Counter();
            try (counter) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("\nВведите кличку животного: ");
                String name = scanner.nextLine();
                if (name.isEmpty()) {
                    throw new InputMismatchException("Кличка должна быть пустой");
                }
                System.out.print("Введите дату рождения в формате ГГГГ-ММ-ДД : ");
                LocalDate birthDate;
                try {
                    birthDate = LocalDate.parse(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("\nНе корректно введена дата\nЖивотное не добавлено!");
                    return false;
                }

                System.out.println("\nДоступные классы животных:");
                String types = ("1. " + CAT.getTitle() + '\n' +
                        "2. " + DOG.getTitle() + '\n' +
                        "3. " + HAMSTER.getTitle() + '\n' +
                        "4. " + HORSE.getTitle() + '\n' +
                        "5. " + CAMEL.getTitle() + '\n' +
                        "6. " + DONKEY.getTitle() + '\n');
                System.out.println(types);
                System.out.print("Выберите класс животного: ");
                String type = scanner.nextLine();
                AbstractAnimal animal = switch (type) {
                    case "1" -> new Cat(name, birthDate);
                    case "2" -> new Dog(name, birthDate);
                    case "3" -> new Hamster(name, birthDate);
                    case "4" -> new Horse(name, birthDate);
                    case "5" -> new Camel(name, birthDate);
                    case "6" -> new Donkey(name, birthDate);
                    default -> throw new RuntimeException("\nНе верно выбран класс животного.\nЖивотное не добавлено");
                };
                Db.db.put(animal.getId(), animal);
                counter.add();
                System.out.println("\nЖивотное добавлено");
                return true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            return true;
        }
    }




}
