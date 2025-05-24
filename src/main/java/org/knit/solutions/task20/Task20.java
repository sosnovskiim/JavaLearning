package org.knit.solutions.task20;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 20, taskDescription = "Обобщения. Типизированный контейнер для чисел")
public class Task20 implements Solution {
    public static void main(String[] args) {
        Task20 task = new Task20();
        task.execute();
    }

    @Override
    public void execute() {
        Box<Integer> integerBox = new Box<>();
        integerBox.add(10);
        integerBox.add(20);
        System.out.println(integerBox.sum());

        Box<Double> doubleBox = new Box<>();
        doubleBox.add(1.5);
        doubleBox.add(2.5);
        System.out.println(doubleBox.sum());
    }
}
