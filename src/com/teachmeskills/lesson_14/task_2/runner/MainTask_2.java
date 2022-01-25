package com.teachmeskills.lesson_14.task_2.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Задание 2. (Основное задание)
 *    Создать коллекцию класса ArrayList со значениями имен всех студентов в группе
 *    С помощью Stream'ов:
 * 	   - Вернуть количество людей с вашим именем (вне зависимости от верхнего/нижнего регистра букв)
 * 	   - Выбрать все имена, начинающиеся на "а" (вне зависимости от верхнего/нижнего регистра букв)
 * 	   - Отсортировать и вернуть первый элемент коллекции или "Empty", если коллекция пуста
 */

public class MainTask_2 {

    public static void main(String[] args) {
        List<String> arrayName = new ArrayList<>(13);
        arrayName.add("Arkadiy");
        arrayName.add("Alexey");
        arrayName.add("Dmitriy");
        arrayName.add("Valdemar");
        arrayName.add("Igor");
        arrayName.add("Jana");
        arrayName.add("Alexandr");
        arrayName.add("Ivan");
        arrayName.add("Maxim");
        arrayName.add("Daniil");
        arrayName.add("Ekaterina");
        arrayName.add("Pavel");
        arrayName.add("Andrian");

        long quantity = arrayName.stream()
                .map(String::toLowerCase)
                .filter("pavel"::equals)
                .count();
        System.out.println("Кол-во людей с вашим именем: "+ quantity);  // если 1, то это ты сам

        List<String> allNameOnA = arrayName.stream()
                .map(String::toLowerCase)
                .filter((p) -> p.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println("Все имена, начинающиеся на \"а\": "+ allNameOnA);

        String existsFirstElement = arrayName.stream()
                .sorted()
                .findFirst().orElse("Empty");
        System.out.println("Проверяем, есть ли первый элемент в коллекции: "+ existsFirstElement);
    }

}
