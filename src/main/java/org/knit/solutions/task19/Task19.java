package org.knit.solutions.task19;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 19, taskDescription = "Обобщения. Поиск максимума")
public class Task19 implements Solution {
    public static void main(String[] args) {
        Task19 task = new Task19();
        task.execute();
    }

    @Override
    public void execute() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println(findMax(numbers));

        String[] words = {"apple", "banana", "cherry"};
        System.out.println(findMax(words));
    }

    private static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = array[i].compareTo(max) > 0 ? array[i] : max;
        }
        return max;
    }
}
