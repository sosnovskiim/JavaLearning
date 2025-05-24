package org.knit.solutions.task36;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 36, taskDescription = "Паттерны. Наблюдатель (Observer)")
public class Task36 implements Solution {
    public static void main(String[] args) {
        Task36 task = new Task36();
        task.execute();
    }

    @Override
    public void execute() {
        Stock stock = new Stock("Tesla");
        MobileApp mobileApp = new MobileApp();
        EmailApp emailApp = new EmailApp();

        stock.attach(mobileApp);
        stock.attach(emailApp);

        System.out.println("Изменение стоимости.");
        stock.setPrice(21000);

        System.out.println("\nОтписка от уведомлений и изменение стоимости.");
        stock.detach(emailApp);
        stock.setPrice(20500);
    }
}
