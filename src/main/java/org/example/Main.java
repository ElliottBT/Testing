package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private File file;

    public Main(File file) {
        this.file = file;
    }

    public enum Month {
        Январь, Февраль, Март, Апрель, Май, Июнь, Июль, Август, Сентябрь, Октябрь, Ноябрь, Декабрь;
    }

    public static String getUserChoice() {
        Scanner scannerFunction = new Scanner(System.in);
        String choice = scannerFunction.nextLine();
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("exit")) {
            System.out.println("Нет такой функции!");
            System.out.print("Ваш выбор: ");
            choice = scannerFunction.nextLine();
        }
        return choice;
    }

    public static void addHolidayToFile(File file, Scanner scannerInput, ArrayList<String> holidays) {
        String nameOfHoliday = "";
        System.out.print("Введите название месяца: ");
        String chosenMonth = scannerInput.nextLine();
        while (true) {
            try {
                Month.valueOf(chosenMonth);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Вы ввели несуществующий месяц!");
                System.out.print("Введите название месяца: ");
                chosenMonth = scannerInput.nextLine();
            }
        }
        System.out.print("Введите название праздника: ");
        nameOfHoliday = scannerInput.nextLine();
        String newHoliday = chosenMonth + "," + nameOfHoliday;
        holidays.add(newHoliday);
        try {
            FileWriter writer = new FileWriter(file, true);
            PrintWriter printer = new PrintWriter(writer);
            printer.println(newHoliday);
            printer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
    }

    public static void deleteHolidayFromFile(File file, String holidayName) {
        String chosenMonth;
        ArrayList<String> holidays = new ArrayList<String>();
        File fileHolidays = new File("holidays.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String> lines = new ArrayList<String>();
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains(holidayName)) {
                    lines.add(line);
                }
            }
            reader.close(); // Закрываем файл после чтения
            FileWriter writer = new FileWriter(file);
            for (String str : lines) {
                writer.write(str + "\n");
            }
            writer.close();
            System.out.println("Праздник месяца \"" + holidayName + "\" удален из файла.");
        } catch (IOException e) {
            System.out.println("Ошибка удаления праздника из файла.");
        }
    }

    public static ArrayList<String> showHolidaysByMonth() {
        String chosenMonth;
        ArrayList<String> holidays = new ArrayList<String>();
        File fileHolidays = new File("holidays.txt");
        System.out.println("Список месяцев:");
        for (Month month : Month.values()) {
            System.out.println(month);
        }
        Scanner scannerSelect = new Scanner(System.in);
        System.out.print("Выберите месяц: ");
        while (true) {
            try {
                chosenMonth = scannerSelect.nextLine();
                Month month = Month.valueOf(chosenMonth);
                System.out.println("Выбран месяц: " + month);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Данного месяца не существует!");
            }
        }
        Scanner scannerHolidays = null;
        try {
            scannerHolidays = new Scanner(fileHolidays);
        } catch (FileNotFoundException e) {
            System.out.println("Файл с праздниками не найден!");
        }
        System.out.println("Праздники:");
        int k = 1;
        while (scannerHolidays.hasNextLine()) {
            String line = scannerHolidays.nextLine();
            String[] parts = line.split(",");
            if (parts[0].equals(chosenMonth.toString())) {
                System.out.println("[" + k + "] - " + parts[1]);
                holidays.add(line);
                k++;
            }
        }
        return holidays;
    }

    public static void main(String[] args){
        String funcPrint = "Функции программы: \n[1] - Просмотр праздников;\n[2] - Добавление праздников;\n[3] - Удаление праздников;\n[exit] - Выход из программы;";
        System.out.println(funcPrint);
        System.out.print("Ваш выбор: ");
        Scanner scannerFunction = new Scanner(System.in);
        String choice = getUserChoice();
        String chosenMonth;
        ArrayList<String> holidays = new ArrayList<String>();
        File
                fileHolidays = new File("holidays.txt");
        Scanner scannerInput = new Scanner(System.in); // добавлено создание scannerInput
        while (choice.equals("exit") == false) {
            switch (choice) {
                case "1":
                    holidays = showHolidaysByMonth();
                    System.out.println(funcPrint);
                    System.out.print("Выберите функцию: ");
                    choice = scannerFunction.nextLine();
                    break;
                case "2":
                    addHolidayToFile(fileHolidays, scannerInput, holidays);
                    System.out.println(funcPrint);
                    System.out.println("Выберите функцию: ");
                    choice = getUserChoice();
                    String nameOfHoliday = "";
                    break;
                case "3":
                    holidays = showHolidaysByMonth();
                    System.out.println("Введите номер праздника: ");
                    int numberOfHoliday = scannerInput.nextInt();
                    if (!holidays.isEmpty() && numberOfHoliday > 0 && numberOfHoliday <= holidays.size()) {
                        nameOfHoliday = holidays.get(numberOfHoliday - 1);
                        if (holidays.contains(nameOfHoliday)) {
                            deleteHolidayFromFile(fileHolidays, nameOfHoliday);
                            holidays.remove(nameOfHoliday);
                        }
                    } else {
                        System.out.println("Праздник не найден!");
                    }
                    System.out.println(funcPrint);
                    System.out.println("Выберите функцию: ");
                    choice = getUserChoice();
                    break;
            }
        }
    }
}