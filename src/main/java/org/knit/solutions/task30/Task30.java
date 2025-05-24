package org.knit.solutions.task30;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 30, taskDescription = "Потоки. Повар и официант")
public class Task30 implements Solution {
    public static void main(String[] args) {
        Task30 task = new Task30();
        task.execute();
    }

    @Override
    public void execute() {
        Restaurant restaurant = new Restaurant();
        Thread cookerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                restaurant.cook(String.valueOf(i));
            }
        });
        Thread waiterThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                restaurant.serve();
            }
        });
        cookerThread.start();
        waiterThread.start();
    }
}
