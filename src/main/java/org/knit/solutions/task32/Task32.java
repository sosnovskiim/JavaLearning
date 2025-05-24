package org.knit.solutions.task32;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 32, taskDescription = "Потоки. Производитель и потребитель")
public class Task32 implements Solution {
    public static void main(String[] args) {
        Task32 task = new Task32();
        task.execute();
    }

    @Override
    public void execute() {
        Storage storage = new Storage();
        int productsNumber = 10;
        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < productsNumber; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                storage.produce(i);
            }
        });
        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < productsNumber; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                storage.consume();
            }
        });
        producerThread.start();
        consumerThread.start();
    }
}
