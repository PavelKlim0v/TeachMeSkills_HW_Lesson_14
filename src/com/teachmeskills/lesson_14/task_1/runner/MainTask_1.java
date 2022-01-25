package com.teachmeskills.lesson_14.task_1.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *  Задание 1. (Основное задание)
 *    Создать коллекцию класса ArrayList наполнить ее элементами рандомными элементами типа Integer.
 *     С помощью Stream'ов:
 * 	    - Удалить дубликаты
 * 	    - Вывести все четные элементы в диапазоне от 7 до 17 (включительно)
 * 	    - Каждый элемент умножить на 2
 * 	    - Отсортировать и вывести на экран первых 4 элемента
 * 	    - Вывести количество элементов в стриме
 * 	    - Вывести среднее арифметическое всех чисел в стриме
 */

public class MainTask_1 {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        Random r = new Random();

        int iteration = 0;
        while (iteration < 20) {
            array.add(r.nextInt(100));  // случайное число в диапазоне от 0 до 100
            iteration++;
        }

        System.out.println(array);

        List<Integer> streamFromArrayList = array.stream()
                .distinct()
                .filter((f) -> (f >= 7 && f <= 17 && f % 2 == 0))
                .map(m -> m * 2)
                .collect(Collectors.toList());
        System.out.println("Без дубликатов, только четные элементы от 7 до 17, каждый элемент умножен на 2 "+ streamFromArrayList);

        List<Integer> firstFourElement = array.stream()
                .sorted()
                .limit(4)
                .collect(Collectors.toList());
        System.out.println("Первые четыре элемента отсортированных: "+ (Arrays.toString(new List[]{firstFourElement})));

        long countElement = array.stream()
                .count();
        System.out.println("Кол-во элементов в стриме: "+ countElement);

        double average = array.stream()
                .mapToInt(Integer::intValue)
                .sum() / (double) array.size();
        System.out.println("Среднее арифметическое = "+ average);
    }

}
