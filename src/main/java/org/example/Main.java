package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int mes = 0;
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Выберите месяц:");
        System.out.println("[1]: Январь \n[2]: Февраль \n[3]: Март \n[4]: Апрель \n[5]: Май \n[6]: Июнь \n[7]: Июль \n[8]: Август \n[9]: Сентябрь \n[10]: Октябрь \n[11]: Ноябрь \n[12]: Декабрь");
        System.out.println("Для завершения вывода информации введите exit");
        while (true) { //Продолжаем ввод пока не будет введено число в диапазоне от 1 до 12

            System.out.print("Ваш выбор: ");
            try {
                String enter = reader.readLine();
                if (enter.equals("exit")) {
                    break;
                }
                mes = Integer.parseInt(enter);

                if (mes < 1 || mes > 12) {
                    System.out.println("Данного месяца не существует!");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: неверный формат данных");
            }

            switch (mes) {

                case 1:
                    System.out.println("Праздники:");
                    System.out.println("1 января - 'Новый год'");
                    System.out.println("6 января - 'Рождественский сочельник'");
                    System.out.println("7 января - 'Рождественский христово'");
                    System.out.println("14 января - 'Старый новый год'");

                    break;
                case 2:
                    System.out.println("Праздники:");
                    System.out.println("20 февраля - 'Масленица'");
                    System.out.println("12 февраля - 'День Дарвина'");

                    break;
                case 3:
                    System.out.println("Праздники:");
                    System.out.println("3 марта - 'Всемирный день писателя'");
                    System.out.println("8 марта - 'Международный женский день'");
                    break;
                case 4:
                    System.out.println("Праздники:");
                    System.out.println("1 апреля - 'День смеха'");
                    System.out.println("4 апреля - 'День Интернета'");
                    break;
                case 5:
                    System.out.println("Праздники:");
                    System.out.println("1 мая - 'Праздник труда, Первое мая'");
                    System.out.println("9 мая - 'День Победы'");
                    break;
                case 6:
                    System.out.println("Праздники:");
                    System.out.println("1 июня - 'Международный день защиты детей'");
                    System.out.println("10 июня - 'Всемирный день мороженого'");
                    break;
                case 7:
                    System.out.println("Праздники:");
                    System.out.println("4 июля - 'День отдыха от праздников'");
                    System.out.println("5 июля - 'День трудоголиков'");
                    break;
                case 8:
                    System.out.println("Праздники:");
                    System.out.println("8 августа - 'Всемирный день кошек'");
                    System.out.println("19 августа - 'Всемирный день фотографии'");
                    break;
                case 9:
                    System.out.println("Праздники:");
                    System.out.println("1 сентября - 'День знаний'");
                    System.out.println("6 сентября - 'День рыжих'");
                    break;
                case 10:
                    System.out.println("Праздники:");
                    System.out.println("1 октября - 'День учителя '");
                    System.out.println("2 октября - 'Международный день врача '");
                    break;
                case 11:
                    System.out.println("Праздники:");
                    System.out.println("10 ноября - 'Всемирный день молодежи'");
                    System.out.println("13 ноября - 'Всемирный день доброты'");
                    break;
                case 12:
                    System.out.println("Праздники:");
                    System.out.println("1 декаря - 'День невролога'");
                    System.out.println("8 декабря - 'Международный день художника'");
            }
        }
    }
}