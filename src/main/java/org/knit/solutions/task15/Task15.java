package org.knit.solutions.task15;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 15, taskDescription = "Перечисления. Времена года")
public class Task15 implements Solution {
    public static void main(String[] args) {
        Task15 task = new Task15();
        task.execute();
    }

    @Override
    public void execute() {
        for (Season season : Season.values()) {
            System.out.printf(
                    "It's usually %s in %s.\n",
                    season.getTemperature().toLowerCase(),
                    season.toString().toLowerCase()
            );
            System.out.printf(
                    "The most important holiday of %s is %s.\n",
                    season.toString().toLowerCase(),
                    season.getHoliday()
            );
        }
    }
}
