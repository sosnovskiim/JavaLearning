package org.knit.solutions.task14;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.util.Scanner;

@TaskDescription(taskNumber = 14, taskDescription = "Перечисления. Сигналы светофора")
public class Task14 implements Solution {
    public static void main(String[] args) {
        Task14 task = new Task14();
        task.execute();
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf(
                "Введите текущий сигнал светофора (%s, %s, %s): ",
                TrafficLight.RED, TrafficLight.YELLOW, TrafficLight.GREEN
        );
        TrafficLight light = TrafficLight.valueOf(scanner.nextLine());
        System.out.println("Следующий сигнал светофора: " + light.getNextLight());
    }
}
