package org.knit.solutions.task37;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 37, taskDescription = "Паттерны. Хранитель (Memento)")
public class Task37 implements Solution {
    public static void main(String[] args) {
        Task37 task = new Task37();
        task.execute();
    }

    @Override
    public void execute() {
        TextEditor notepad = new TextEditor();
        TextTaker textTaker = new TextTaker(notepad);

        textTaker.undoChanges();
        System.out.println(notepad.getText());

        System.out.println("Добавление строки текста.");
        notepad.addText("Hello, world!");
        System.out.println(notepad.getText());
        textTaker.saveText();
        System.out.println(notepad.getText());

        System.out.println("Добавление строки текста.");
        notepad.addText("How are you?");
        System.out.println(notepad.getText());
        textTaker.undoChanges();
        System.out.println(notepad.getText());
    }
}
