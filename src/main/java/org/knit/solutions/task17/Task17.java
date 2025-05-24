package org.knit.solutions.task17;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 17, taskDescription = "Валидация полей с помощью аннотаций")
public class Task17 implements Solution {
    public static void main(String[] args) {
        Task17 task = new Task17();
        task.execute();
    }

    @Override
    public void execute() {
        User user = new User(null, "LongUsername", 16);
        try {
            Validator.validate(user);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
