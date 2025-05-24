package org.knit.solutions.task45;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.knit.solutions.task45.model.PasswordEntry;
import org.knit.solutions.task45.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Slf4j
@Component
public class PasswordManager implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private PasswordService passwordService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Scanner scanner = new Scanner(System.in);
        char[] masterPassword;
        boolean isMasterPasswordCorrect = false;
        while (!isMasterPasswordCorrect) {
            System.out.print("Введите мастер-пароль: ");
            masterPassword = System.console() != null
                    ? System.console().readPassword()
                    : scanner.nextLine().toCharArray();
            if (passwordService.isMasterPasswordCorrect(masterPassword)) {
                isMasterPasswordCorrect = true;
                String message = "Успешный вход в систему.";
                log.info(message);
                System.out.println(message);
            } else {
                String message = "Ошибка: неверный мастер-пароль.";
                log.error(message);
                System.out.println(message);
            }
        }
        System.out.println("\nДоступные команды для управления паролями:\n" +
                "\tadd - добавить новую запись (сайт, логин, пароль);\n" +
                "\tlist - вывести список всех сохранённых записей;\n" +
                "\tcopy [site] - скопировать пароль от сайта;\n" +
                "\tdelete [site] - удалить запись по названию сайта;\n" +
                "\texit - завершить работу программы.");
        String action = "";
        while (!action.equals("exit")) {
            System.out.print("\nВведите команду: ");
            String[] params = scanner.nextLine().split(" ");
            action = params[0];
            switch (action) {
                case "add":
                    onActionAdd(scanner);
                    break;
                case "list":
                    onActionList();
                    break;
                case "copy":
                    if (params.length == 2) {
                        onActionCopy(params[1]);
                    } else {
                        System.out.println("Неверное количество параметров.");
                    }
                    break;
                case "delete":
                    if (params.length == 2) {
                        onActionDelete(params[1]);
                    } else {
                        System.out.println("Неверное количество параметров.");
                    }
                    break;
                case "exit":
                    onActionExit();
                    break;
                default:
                    System.out.println("Ошибка: команда \"" + action + "\" не найдена.");
            }
        }
    }

    private void onActionAdd(Scanner scanner) {
        String site = "";
        while (site.isEmpty()) {
            System.out.print("Введите название сайта: ");
            site = scanner.nextLine();
        }
        String login = "";
        while (login.isEmpty()) {
            System.out.print("Введите логин: ");
            login = scanner.nextLine();
        }
        String password = "";
        while (password.isEmpty()) {
            System.out.print("Введите пароль: ");
            password = System.console() != null
                    ? Arrays.toString(System.console().readPassword())
                    : scanner.nextLine();
        }
        System.out.println(passwordService.addPasswordEntry(site, login, password));
    }

    @SneakyThrows
    private void onActionList() {
        List<PasswordEntry> passwordEntries = passwordService.getPasswordEntries();
        if (!passwordEntries.isEmpty()) {
            passwordEntries.forEach(System.out::println);
        } else {
            System.out.println("Нет записей.");
        }
    }

    private void onActionCopy(String site) {
        System.out.println(passwordService.copyPasswordToClipboard(site));
    }

    private void onActionDelete(String site) {
        System.out.println(passwordService.deletePasswordEntry(site));
    }

    private void onActionExit() {
        passwordService.savePasswordEntries();
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> passwordService.clearMasterPassword())
        );
        String message = "Выход из программы.";
        log.info(message);
        System.out.println(message);
    }
}
