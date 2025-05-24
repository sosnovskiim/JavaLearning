package org.knit.solutions.task38;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 38, taskDescription = "Паттерны. Команда (Command)")
public class Task38 implements Solution {
    public static void main(String[] args) {
        Task38 task = new Task38();
        task.execute();
    }

    @Override
    public void execute() {
        Light light = new Light();
        Conditioner conditioner = new Conditioner();
        RemoteControl remoteControl = new RemoteControl();

        Command turnOnLight = new TurnOnLight(light);
        Command turnOffLight = new TurnOffLight(light);
        Command turnOnConditioner = new TurnOnConditioner(conditioner);
        Command turnOffConditioner = new TurnOffConditioner(conditioner);

        remoteControl.undoCommand();
        remoteControl.executeCommand(turnOnLight);
        remoteControl.executeCommand(turnOnConditioner);
        remoteControl.executeCommand(turnOnConditioner);
        remoteControl.undoCommand();
        remoteControl.executeCommand(turnOffConditioner);
        remoteControl.executeCommand(turnOffLight);
    }
}
