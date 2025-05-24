package org.knit.solutions.task34;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 34, taskDescription = "Потоки. Конвейер для сборки деталей")
public class Task34 implements Solution {
    public static void main(String[] args) {
        Task34 task = new Task34();
        task.execute();
    }

    @Override
    public void execute() {
        Factory.makeDetails(10);
    }
}
