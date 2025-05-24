package org.knit.solutions.task41;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 41, taskDescription = "Паттерны. Приспособленец (Flyweight)")
public class Task41 implements Solution {
    public static void main(String[] args) {
        Task41 task = new Task41();
        task.execute();
    }

    @Override
    public void execute() {
        CharacterFactory characterFactory = new CharacterFactory();

        Character character1 = characterFactory.getCharacter("100");
        Character character2 = characterFactory.getCharacter("101");
        Character character3 = characterFactory.getCharacter("110");
        Character character4 = characterFactory.getCharacter("101");
        Character character5 = characterFactory.getCharacter("100");

        character1.render(0, 0, "обычный");
        character2.render(0, 1, "полужирный");
        character3.render(0, 2, "курсив");
        character4.render(1, 0, "подчёркнутый");
        character5.render(1, 1, "обычный");
    }
}
