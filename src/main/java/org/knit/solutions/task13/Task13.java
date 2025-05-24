package org.knit.solutions.task13;

import org.knit.TaskDescription;
import org.knit.solutions.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@TaskDescription(taskNumber = 13, taskDescription = "Сериализация списка пользователей")
public class Task13 implements Solution {
    public static void main(String[] args) {
        Task13 task = new Task13();
        task.execute();
    }

    @Override
    public void execute() {
        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Доступные действия:\n" +
                "1. Добавление пользователя\n" +
                "2. Показать список пользователей\n" +
                "3. Сохранить список пользователей\n" +
                "4. Загрузить список пользователей\n" +
                "5. Выход из программы");
        String action = "";
        while (!action.equals("5")) {
            System.out.print("\nВыберите действие: ");
            action = scanner.nextLine();
            switch (action) {
                case "1":
                    System.out.print("Введите имя пользователя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите возраст пользователя: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите почту пользователя: ");
                    String email = scanner.nextLine();
                    users.add(new User(name, age, email));
                    System.out.println("Пользователь успешно добавлен.");
                    break;
                case "2":
                    System.out.println("Список пользователей:");
                    users.forEach(System.out::println);
                    break;
                case "3":
                    try {
                        UserManager.uploadUsers(users);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Список пользователей успешно сохранен.");
                    break;
                case "4":
                    try {
                        users = UserManager.downloadUsers();
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Список пользователей успешно загружен.");
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
