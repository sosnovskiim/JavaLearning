package org.knit.solutions.task25;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Scanner;

@TaskDescription(taskNumber = 25, taskDescription = "Сохранение файлов в базу данных SQLite")
public class Task25 implements Solution {
    public static void main(String[] args) {
        Task25 task = new Task25();
        task.execute();
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу или папке: ");
        SimpleFileVisitor simpleFileVisitor = new SimpleFileVisitor();
        try {
            Files.walkFileTree(Paths.get(scanner.nextLine()), simpleFileVisitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
