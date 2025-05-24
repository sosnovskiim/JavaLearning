package org.knit.solutions.task22;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 22, taskDescription = "Обобщения. Реализация класса Dictionary")
public class Task22 implements Solution {
    public static void main(String[] args) {
        Task22 task = new Task22();
        task.execute();
    }

    @Override
    public void execute() {
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        dictionary.put("Alice", 25);
        dictionary.put("Bob", 30);
        dictionary.put("Joe", 40);
        System.out.println(dictionary);

        System.out.println(dictionary.get("Alice"));
        dictionary.remove("Bob");
        System.out.println(dictionary);
    }
}
