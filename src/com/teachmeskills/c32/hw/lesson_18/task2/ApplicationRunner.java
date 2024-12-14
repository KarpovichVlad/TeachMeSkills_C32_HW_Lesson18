package com.teachmeskills.c32.hw.lesson_18.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Создать коллекцию класса ArrayList со значениями имен всех студентов в группе
 *  С помощью Stream'ов:
 *  - Выбрать все имена, начинающиеся на любую букву, введенную с консоли (вне зависимости от верхнего/нижнего регистра букв)
 *  - Отсортировать и вернуть первый элемент коллекции
 */

public class ApplicationRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> names = new ArrayList<>();

        names.add("Andrew");
        names.add("Kate");
        names.add("Dmitry");
        names.add("Kirill");
        names.add("Oleg");
        names.add("Fluffic");
        names.add("Sergio");
        names.add("Rita");
        names.add("Dmitry");
        names.add("Flame_host");
        names.add("Marina");
        names.add("Ilya");
        names.add("Vlad");
        names.add("Igor");
        names.add("Daniil");
        names.add("Sultan");

        System.out.println("Введите первую букву имени для поиска:");
        String input = scanner.nextLine().trim();

        if (input.isEmpty() || input.length() > 1) {
            System.out.println("Введите только одну букву.");
            return;
        }

        char firstLetter = input.charAt(0);

        String result = names.stream()
                .filter(name -> name.toLowerCase().startsWith(String.valueOf(firstLetter).toLowerCase()))
                .sorted()
                .findFirst()
                .orElse(null);

        if (result != null) {
            System.out.println("Первое имя: " + result);
        } else {
            System.out.println("Не найдено имен, начинающихся на букву '" + firstLetter + "'.");
        }
    }
}
