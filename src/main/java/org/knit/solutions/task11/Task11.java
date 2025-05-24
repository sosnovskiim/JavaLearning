package org.knit.solutions.task11;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

@TaskDescription(taskNumber = 11, taskDescription = "Управление списком студентов")
public class Task11 implements Solution {
    public static void main(String[] args) {
        Task11 task = new Task11();
        task.execute();
    }

    @Override
    public void execute() {
        Set<String> students = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Доступные действия:\n" +
                "1. Добавление студента\n" +
                "2. Удаление студента\n" +
                "3. Список студентов\n" +
                "4. Поиск студента\n" +
                "5. Выход из программы");
        String action = "";
        while (!action.equals("5")) {
            System.out.print("\nВыберите действие: ");
            action = scanner.nextLine();
            String student;
            switch (action) {
                case "1":
                    System.out.print("Введите имя студента: ");
                    student = scanner.nextLine();
                    if (!students.contains(student)) {
                        students.add(student);
                        System.out.printf("Студент %s добавлен.\n", student);
                    } else {
                        System.out.println("Ошибка: студент с таким именем уже добавлен.");
                    }
                    break;
                case "2":
                    System.out.print("Введите имя студента: ");
                    student = scanner.nextLine();
                    if (students.contains(student)) {
                        students.remove(student);
                        System.out.printf("Студент %s удален.\n", student);
                    } else {
                        System.out.println("Ошибка: студент с таким именем не найден.");
                    }
                    break;
                case "3":
                    System.out.println("Список студентов:");
                    students.forEach(System.out::println);
                    break;
                case "4":
                    System.out.print("Введите имя студента: ");
                    student = scanner.nextLine();
                    if (students.contains(student)) {
                        System.out.printf("Студент %s найден.\n", student);
                    } else {
                        System.out.println("Студент с таким именем не найден.");
                    }
                    break;
                case "5":
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Ошибка: неверное действие.");
            }
        }
    }
}
