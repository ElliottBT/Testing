package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String funcPrint = "Функции программы: \n[1] - Просмотр праздников;\n[2] - Добавление праздников;\n[3] - Удаление праздников;\n[exit] - Выход из программы;";
        System.out.println(funcPrint);
        System.out.print("Ваш выбор: ");
        Scanner scannerFunction = new Scanner(System.in);
        Holidays holidays1 = new Holidays();
        String choice = holidays1.getUserChoice();
        ArrayList<String> holidays = new ArrayList<String>();
        File
                fileHolidays = new File("holidays.txt");
        Scanner scannerInput = new Scanner(System.in); // добавлено создание scannerInput
        while (choice.equals("exit") == false) {
            switch (choice) {
                case "1":
                    holidays = holidays1.showHolidaysByMonth();
                    System.out.println(funcPrint);
                    System.out.print("Выберите функцию: ");
                    choice = scannerFunction.nextLine();
                    break;
                case "2":
                    holidays1.addHolidayToFile(fileHolidays, scannerInput, holidays);
                    System.out.println(funcPrint);
                    System.out.println("Выберите функцию: ");
                    choice = holidays1.getUserChoice();
                    String nameOfHoliday = "";
                    break;
                case "3":
                    holidays = holidays1.showHolidaysByMonth();
                    System.out.println("Введите номер праздника: ");
                    int numberOfHoliday = scannerInput.nextInt();
                    if (!holidays.isEmpty() && numberOfHoliday > 0 && numberOfHoliday <= holidays.size()) {
                        nameOfHoliday = holidays.get(numberOfHoliday - 1);
                        if (holidays.contains(nameOfHoliday)) {
                            holidays1.deleteHolidayFromFile(fileHolidays, nameOfHoliday);
                            holidays.remove(nameOfHoliday);
                        }
                    } else {
                        System.out.println("Праздник не найден!");
                    }
                    System.out.println(funcPrint);
                    System.out.println("Выберите функцию: ");
                    choice = holidays1.getUserChoice();
                    break;
            }
        }
    }
}

