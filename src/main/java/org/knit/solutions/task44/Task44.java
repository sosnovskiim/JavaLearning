package org.knit.solutions.task44;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

@TaskDescription(taskNumber = 44, taskDescription = "Парадокс Монти Холла")
public class Task44 implements Solution {
    public static void main(String[] args) {
        Task44 task = new Task44();
        task.execute();
    }

    @Override
    public void execute() {
        int testsNumber = 1000000;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");

        int winsNumber = 0;
        for (int i = 0; i < testsNumber; i++) {
            int prizeDoor = chooseDoor();
            int playerChoice = chooseDoor();
            if (prizeDoor == playerChoice) {
                winsNumber++;
            }
        }
        System.out.printf(
                "Вероятность выигрыша, если не менять выбор: %s\n",
                decimalFormat.format((float) winsNumber / testsNumber)
        );

        winsNumber = 0;
        for (int i = 0; i < testsNumber; i++) {
            int prizeDoor = chooseDoor();
            int playerChoice = chooseDoor();
            int nonPrizeDoor = chooseDoor();
            while (nonPrizeDoor == prizeDoor || nonPrizeDoor == playerChoice) {
                nonPrizeDoor = chooseDoor();
            }
            int anotherChoise = chooseDoor();
            while (anotherChoise == playerChoice || anotherChoise == nonPrizeDoor) {
                anotherChoise = chooseDoor();
            }
            if (prizeDoor == anotherChoise) {
                winsNumber++;
            }
        }
        System.out.printf(
                "Вероятность выигрыша, если изменять выбор: %s\n",
                decimalFormat.format((float) winsNumber / testsNumber)
        );
    }

    public static int chooseDoor() {
        return ThreadLocalRandom.current().nextInt(3);
    }
}
