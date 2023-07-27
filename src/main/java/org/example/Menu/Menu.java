package org.example.Menu;

public class Menu {

    public Menu() {
    }

    public void showMainMenu() {
        String menu = (
                "1. Показать список всех животных\n" +
                "2. Добавить животное\n" +
                "3. Показать команды животного\n" +
                "4. Добавить новые команды животному\n" +
                "5. Выход"
                );
        System.out.println(menu);
    }
}
