package org.knit.solutions.task29;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 29, taskDescription = "Потоки. Автозаправочная станция")
public class Task29 implements Solution {
    public static void main(String[] args) {
        Task29 task = new Task29();
        task.execute();
    }

    @Override
    public void execute() {
        GasStation gasStation = new GasStation(2);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> gasStation.refuel(String.valueOf(finalI))).start();
        }
    }
}
