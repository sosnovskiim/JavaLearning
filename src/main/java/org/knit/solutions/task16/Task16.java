package org.knit.solutions.task16;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.util.ArrayList;
import java.util.List;

@TaskDescription(taskNumber = 16, taskDescription = "Перечисления. Колода карт")
public class Task16 implements Solution {
    public static void main(String[] args) {
        Task16 task = new Task16();
        task.execute();
    }

    @Override
    public void execute() {
        List<Card> deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                deck.add(new Card(suit, value));
            }
        }
        deck.forEach(System.out::println);
    }
}
