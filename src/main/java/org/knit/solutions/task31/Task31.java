package org.knit.solutions.task31;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 31, taskDescription = "Потоки. Железнодорожный переезд")
public class Task31 implements Solution {
    public static void main(String[] args) {
        Task31 task = new Task31();
        task.execute();
    }

    @Override
    public void execute() {
        RailwayCrossing railwayCrossing = new RailwayCrossing();
        Thread trainThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                railwayCrossing.train();
            }
        });
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Thread carThread = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    railwayCrossing.car(finalI);
                }
            });
            carThread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        trainThread.start();
    }
}
