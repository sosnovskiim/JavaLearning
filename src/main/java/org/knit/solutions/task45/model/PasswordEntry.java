package org.knit.solutions.task45.model;

import lombok.Getter;

@Getter
public class PasswordEntry {
    private String site;
    private String login;
    private String encryptedPassword;

    public PasswordEntry(String site, String login, String encryptedPassword) {
        this.site = site;
        this.login = login;
        this.encryptedPassword = encryptedPassword;
    }

    public PasswordEntry() {
    }

    @Override
    public String toString() {
        return site + " - " + login;
    }
}
