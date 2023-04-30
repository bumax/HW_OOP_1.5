package view;

import model.User;

import java.util.Scanner;

public class View {
    public View() {
    }

    public void mainMenu() {
        System.out.println("Выберите действие:\n" +
                "1 - Показать всю книгу, 2 - Добавить контакт, 3 - Удалить контакт, 4 - Изменить контакт\n" +
                "5 - Поиск контакта, 6 - Импорт из CSV, 7 - Импорт из XML, 8 - Экспорт в CSV, 9 - Экспорт в XML:");
    }

    public void showAllData(String data) {
        System.out.println(data);
    }

    public void addContact(boolean res) {
        if (res)
            System.out.println("Успешно!");
        else
            System.out.println("Ошибка!");
    }

    public void removeContact(boolean res) {
        if (res)
            System.out.println("Успешно!");
        else
            System.out.println("Ошибка!");
    }

    public void editContact(int res) {
        switch (res) {
            case -1:
                System.out.println("Ошибка!");
                break;
            case 0:
                System.out.println("Нет изменений!");
                break;
            case 1:
                System.out.println("Успешно!");
                break;
        }
    }

    public void findContact(User user){
        if(user==null)
            System.out.println("Запись не найдена!");
        else{
            System.out.println("Запись найдена!");
            System.out.println(user);
        }

    }

    public void exportData(){
        System.out.println("Эксопрт успешно завершен!");
    }

    public void importData(){
        System.out.println("Импорт успешно завершен!");
    }

    private Scanner scan = new Scanner(System.in);

    /**
     * Получение целочисленного значения от пользователя
     *
     * @param msg Текст в диалоге
     * @return
     */
    public int getIntValue(String msg) {
        System.out.println("Введите " + msg + " (целочисленное):");
        return scan.nextInt();
    }

    /**
     * Получение числа с плавающей точкой от пользователя
     *
     * @param msg Текст в диалоге
     * @return
     */
    public Double getDblValue(String msg) {
        System.out.println("Введите " + msg + " (с плавающей точкой):");
        return scan.nextDouble();
    }

    /**
     * Получение строкового значения от пользователя
     *
     * @param msg Текст в диалоге
     * @return
     */
    public String getStrValue(String msg) {
        System.out.println("Введите " + msg + " (строка):");
        String line = new String();
        while(line.isEmpty())
            line = scan.nextLine();
        return line;
    }

}
