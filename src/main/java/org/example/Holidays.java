package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Holidays {
    public String getUserChoice() {
        Scanner scannerFunction = new Scanner(System.in);
        String choice = scannerFunction.nextLine();
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("exit")) {
            System.out.println("Нет такой функции!");
            System.out.print("Ваш выбор: ");
            choice = scannerFunction.nextLine();
        }
        return choice;
    }

    public void addHolidayToFile(File file, Scanner scannerInput, ArrayList<String> holidays) {
        String nameOfHoliday = "";
        System.out.print("Введите название месяца: ");
        String chosenMonth = scannerInput.nextLine();
        while (true) {
            try {
                Month.Months.valueOf(chosenMonth);
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

    public void deleteHolidayFromFile(File file, String holidayName) {
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

    public ArrayList<String> showHolidaysByMonth() {
        String chosenMonth;
        ArrayList<String> holidays = new ArrayList<String>();
        File fileHolidays = new File("holidays.txt");
        System.out.println("Список месяцев:");
        for (Month.Months months : Month.Months.values()) {
            System.out.println(months);
        }
        Scanner scannerSelect = new Scanner(System.in);
        System.out.print("Выберите месяц: ");
        while (true) {
            try {
                chosenMonth = scannerSelect.nextLine();
                Month.Months months = Month.Months.valueOf(chosenMonth);
                System.out.println("Выбран месяц: " + months);
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
}
