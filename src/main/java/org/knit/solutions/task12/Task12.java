package org.knit.solutions.task12;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

@TaskDescription(taskNumber = 12, taskDescription = "Подсчёт количества слов в текстовых документах")
public class Task12 implements Solution {
    public static void main(String[] args) {
        Task12 task = new Task12();
        task.execute();
    }

    @Override
    public void execute() {
        try {
            CounterFileVisitor fileVisitor = new CounterFileVisitor();
            Files.walkFileTree(Paths.get("src/main/java/org/knit/tasks/task12/folder"), fileVisitor);
            System.out.println("Во всех текстовых документах данной папки " + fileVisitor.wordCount + " слов");
        } catch (IOException e) {
            System.out.println("Ошибка при обходе дерева файлов: " + e.getMessage());
        }
    }

    private static class CounterFileVisitor implements FileVisitor<Path> {
        private int wordCount = 0;

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toString().endsWith(".txt")) {
                try (BufferedReader reader = Files.newBufferedReader(file)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] words = line.split("\\s+");
                        wordCount += words.length;
                    }
                }
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.out.println("Не удалось открыть файл или папку: " + file);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            return FileVisitResult.CONTINUE;
        }
    }
}
