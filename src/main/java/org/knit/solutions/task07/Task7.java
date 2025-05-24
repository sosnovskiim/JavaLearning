package org.knit.solutions.task07;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

@TaskDescription(taskNumber = 7, taskDescription = "Статистика на основе словаря")
public class Task7 implements Solution {
    public static void main(String[] args) {
        Task7 task = new Task7();
        task.execute();
    }

    @Override
    public void execute() {
        DictionaryStatistics dictionaryStatistics =
                DictionaryFactory.createDictionaryStatistics("misc/dictionary.txt");
        if (dictionaryStatistics != null) {
            System.out.println("Количество слов: " + dictionaryStatistics.getDictionarySize());
            System.out.println("Количество палиндромов: " + dictionaryStatistics.getPalindromesNumber());
            System.out.println("Максимальная длина слова: " + dictionaryStatistics.getMaxWordLength());
            System.out.println("Минимальная длина слова: " + dictionaryStatistics.getMinWordLength());
            System.out.println("Случайное слово: " + dictionaryStatistics.getRandomWord());
            System.out.println("Частота букв в словаре:");
            dictionaryStatistics.printLetterStatistics();
        }
    }
}
