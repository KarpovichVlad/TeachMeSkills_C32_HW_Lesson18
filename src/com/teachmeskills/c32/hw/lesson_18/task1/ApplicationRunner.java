package com.teachmeskills.c32.hw.lesson_18.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Создать коллекцию класса ArrayList наполнить ее элементами рандомными элементами типа Integer.
 * С помощью Stream'ов:
 * - Удалить дубликаты
 * - Вывести все четные элементы в диапазоне от 7 до 17 (включительно)
 * - Каждый элемент умножить на 2
 * - Отсортировать и вывести на экран первых 4 элемента
 * - Вывести количество элементов в стриме
 * - Вывести среднее арифметическое всех чисел в стриме
 */

public class ApplicationRunner {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            numbers.add(random.nextInt(50));
        }
        System.out.println("Исходный список: " + numbers);

        List<Integer> unique = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Список без дубликатов: " + unique);

        List<Integer> evens = unique.stream()
                .filter(num -> num % 2 == 0 && num >= 7 && num <= 17)
                .collect(Collectors.toList());
        System.out.println("Четные элементы от 7 до 17 включительно: " + evens);

        List<Integer> doubled = unique.stream()
                .map(num -> num * 2)
                .collect(Collectors.toList());
        System.out.println("Список с элементами, умноженными на 2: " + doubled);

        List<Integer> first4 = unique.stream()
                .sorted()
                .limit(4)
                .collect(Collectors.toList());
        System.out.println("Первые 4 элемента отсортированного списка: " + first4);

        long count = unique.stream().count();
        System.out.println("Количество элементов: " + count);

        unique.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(avg -> System.out.println("Среднее арифметическое: " + avg));
    }
}
