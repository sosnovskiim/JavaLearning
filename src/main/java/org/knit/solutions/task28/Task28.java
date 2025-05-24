package org.knit.solutions.task28;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 28, taskDescription = "Паттерны. Фабрика (Factory)")
public class Task28 implements Solution {
    public static void main(String[] args) {
        Task28 task = new Task28();
        task.execute();
    }

    @Override
    public void execute() {
        String[] types = {"business", "family", "delivery", "truck"};
        for (String type : types) {
            try {
                Transport transport = TransportFactory.createTransport(type);
                System.out.println(transport.getFeatures());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
