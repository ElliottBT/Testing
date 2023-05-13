package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String funcPrint = "Функции программы: \n[1] - Просмотр праздников;\n[2] - Добавление праздников;\n[3] - Удаление праздников;\n[exit] - Выход из программы;";
        System.out.println(funcPrint);
        System.out.print("Ваш выбор: ");
        Holidays holidays1 = new Holidays();
        String nameOfHoliday;
        String choice;
        File
                fileHolidays = new File("holidays.txt");
        Scanner scannerInput = new Scanner(System.in); // добавлено создание scannerInput
        while (!(choice = scannerInput.nextLine()).equals("exit")) {
            switch (choice) {

                case "1":
                    ArrayList<String> holidays;
                    holidays1.showHolidaysByMonth();
                    break;
                case "2":
                    holidays1.addHolidayToFile(fileHolidays, scannerInput);
                    break;
                case "3":
                    holidays = holidays1.showHolidaysByMonth();
                    System.out.println("Введите номер праздника: ");
                    int numberOfHoliday = Integer.parseInt(scannerInput.nextLine());
                    if (!holidays.isEmpty() && numberOfHoliday > 0 && numberOfHoliday <= holidays.size()) {
                        nameOfHoliday = holidays.get(numberOfHoliday - 1);
                        if (holidays.contains(nameOfHoliday)) {
                            holidays1.deleteHolidayFromFile(fileHolidays, nameOfHoliday);
                            holidays.remove(nameOfHoliday);
                        }
                    } else {
                        System.out.println("Праздник не найден! ");
                    }
                    break;
                default:
                    System.out.println("Неверно выбрана функция! ");
                    System.out.println(funcPrint);
                    System.out.println("Выберите функцию заново: ");
                    break;
            }
            System.out.println(funcPrint);
            System.out.println("Выберите функцию: ");
        }
    }
}

