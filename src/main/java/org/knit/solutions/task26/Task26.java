package org.knit.solutions.task26;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 26, taskDescription = "Паттерны. Цепочка обязанностей (Chain of responsibility)")
public class Task26 implements Solution {
    public static void main(String[] args) {
        Task26 task = new Task26();
        task.execute();
    }

    @Override
    public void execute() {
        Handler junior = new JuniorManager();
        Handler senior = new SeniorManager();
        Handler director = new Director();

        junior.setNextHandler(senior);
        senior.setNextHandler(director);

        junior.acceptProblem(new Problem(
                1, "Подсказать, как пройти."
        ));
        junior.acceptProblem(new Problem(
                15, "Оформление дебетовой карты."
        ));
        junior.acceptProblem(new Problem(
                45, "Потерян доступ к счету юридического лица."
        ));
        junior.acceptProblem(new Problem(
                100, "Покупка машины клиенту."
        ));
    }
}
