package org.example;

import org.example.Comands.MenuComands;
import org.example.Menu.Menu;

import java.util.Scanner;

public class Program {

    public static void run() throws Exception {
        Scanner sc = new Scanner(System.in);
        Menu mn = new Menu();
        MenuComands mc = new MenuComands();

        while (true) {
            try {
            System.out.println("Список команд:");
            mn.showMainMenu();
            System.out.print("\nВведите номер команды: ");
            String comand = sc.nextLine();
            switch (comand) {
                case "1": mc.addAnimal();
                    break;
                case "2": System.out.println("Сделать меню");
                    break;
                case "3":
                    System.out.println("Сделать меню");
                case "4": break;
                default:
                    System.out.println("\nНе верно введён номер команды\n");
            }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }



    }
}
