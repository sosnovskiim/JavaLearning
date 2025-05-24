package org.knit.solutions.task45.repository;

import org.knit.solutions.task45.model.PasswordEntry;

import java.util.List;

public interface PasswordRepository {
    void addPasswordEntry(PasswordEntry passwordEntry);

    void deletePasswordEntry(String site);

    PasswordEntry getPasswordEntry(String site);

    List<PasswordEntry> getPasswordEntries();

    void savePasswordEntries();
}
