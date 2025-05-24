package org.knit.solutions.task21;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@TaskDescription(taskNumber = 21, taskDescription = "Обобщения. Фильтрация списка по предикату")
public class Task21 implements Solution {
    public static void main(String[] args) {
        Task21 task = new Task21();
        task.execute();
    }

    @Override
    public void execute() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry");
        List<String> filteredWords = filter(words, s -> s.startsWith("b"));
        System.out.println(filteredWords);
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
