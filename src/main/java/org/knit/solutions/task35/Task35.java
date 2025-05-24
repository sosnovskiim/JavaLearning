package org.knit.solutions.task35;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TaskDescription(taskNumber = 35, taskDescription = "Потоки. Гонка бегунов")
public class Task35 implements Solution {
    public static void main(String[] args) {
        Task35 task = new Task35();
        task.execute();
    }

    @Override
    public void execute() {
        int runnersNumber = 5;
        CyclicBarrier startBarrier = new CyclicBarrier(runnersNumber, () ->
                System.out.println("Все бегуны готовы к старту. Гонка начинается.")
        );
        CyclicBarrier finishBarrier = new CyclicBarrier(runnersNumber, () ->
                System.out.println("Гонка завершена.")
        );
        ExecutorService executorService = Executors.newFixedThreadPool(runnersNumber);
        for (int i = 0; i < runnersNumber; i++) {
            executorService.submit(new Runner(i, startBarrier, finishBarrier));
        }
        executorService.shutdown();
    }
}
