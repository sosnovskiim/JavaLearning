package org.knit.solutions.task45;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;
import org.knit.solutions.task45.config.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@TaskDescription(taskNumber = 45, taskDescription = "Менеджер паролей на Spring")
public class Task45 implements Solution {
    public static void main(String[] args) {
        Task45 task = new Task45();
        task.execute();
    }

    @Override
    public void execute() {
        new AnnotationConfigApplicationContext(ApplicationConfig.class);
    }
}
