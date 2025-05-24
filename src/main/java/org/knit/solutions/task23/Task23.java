package org.knit.solutions.task23;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 23, taskDescription = "Обобщения. Вывод типа объекта в консоль")
public class Task23 implements Solution {
    public static void main(String[] args) {
        Task23 task = new Task23();
        task.execute();
    }

    @Override
    public void execute() {
        printType(123);
        printType("Hello");
    }

    private static <T> void printType(T obj) {
        System.out.println(obj.getClass());
    }
}
