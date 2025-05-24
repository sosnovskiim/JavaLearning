package org.knit.solutions.task40;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 40, taskDescription = "Паттерны. Прокси (Proxy)")
public class Task40 implements Solution {
    public static void main(String[] args) {
        Task40 task = new Task40();
        task.execute();
    }

    @Override
    public void execute() {
        Image image = new ImageProxy();
        image.request();
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        image.request();
    }
}
