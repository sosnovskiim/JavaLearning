package org.knit.solutions.task01;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 1, taskDescription = "Вывод чисел от 1 до 100 в консоль.")
public class Task1 implements Solution {
    public static void main(String[] args) {
        Task1 task = new Task1();
        task.execute();
    }

    @Override
    public void execute() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 99; i += 10) {
            for (int j = i; j <= i + 9; j++) {
                result.append(j);
                if (j < i + 9) {
                    result.append(",");
                } else {
                    result.append("\n");
                }
            }
        }
        System.out.println(result);
    }
}
