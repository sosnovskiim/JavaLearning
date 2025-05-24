package org.knit.solutions.task18;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 18, taskDescription = "Обобщения. Реализация класса Pair")
public class Task18 implements Solution {
    public static void main(String[] args) {
        Task18 task = new Task18();
        task.execute();
    }

    @Override
    public void execute() {
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        System.out.println(pair);
        pair.setSecondValue(35);
        System.out.println(pair);
    }
}
