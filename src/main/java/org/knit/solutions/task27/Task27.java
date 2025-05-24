package org.knit.solutions.task27;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 27, taskDescription = "Паттерны. Декоратор (Decorator)")
public class Task27 implements Solution {
    public static void main(String[] args) {
        Task27 task = new Task27();
        task.execute();
    }

    @Override
    public void execute() {
        Coffee latte = new Latte();
        System.out.println(coffeeToString(latte));

        latte = new SugarAdditive(latte);
        System.out.println(coffeeToString(latte));

        latte = new CinnamonAdditive(latte);
        System.out.println(coffeeToString(latte));

        Coffee cappuccino = new Cappuccino();
        System.out.println(coffeeToString(cappuccino));

        cappuccino = new MilkAdditive(cappuccino);
        System.out.println(coffeeToString(cappuccino));

        cappuccino = new SugarAdditive(cappuccino);
        System.out.println(coffeeToString(cappuccino));
    }

    private static String coffeeToString(Coffee coffee) {
        return String.format(
                "%s. Цена: %d руб. Объём: %d мл",
                coffee.getDescription(), coffee.getCost(), coffee.getVolume()
        );
    }
}
