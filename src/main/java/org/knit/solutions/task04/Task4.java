package org.knit.solutions.task04;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 4, taskDescription = "Реализация объёмных фигур и контейнера")
public class Task4 implements Solution {
    public static void main(String[] args) {
        Task4 task = new Task4();
        task.execute();
    }

    @Override
    public void execute() {
        Container container = new Container(100);
        container.add(new Cube(3));
        container.add(new Cylinder(2, 4));
        container.add(new Sphere(5));
    }
}
