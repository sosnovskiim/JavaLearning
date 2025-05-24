package org.knit.solutions.task02;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 2, taskDescription = "Парсинг URL")
public class Task2 implements Solution {
    public static void main(String[] args) {
        Task2 task = new Task2();
        task.execute();
    }

    @Override
    public void execute() {
        System.out.println(new SimpleUrl("https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText"));
    }
}
