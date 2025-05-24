package org.knit.solutions.task45.repository;

import lombok.SneakyThrows;
import org.knit.solutions.task45.crypto.EncryptionService;
import org.knit.solutions.task45.model.PasswordEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryPasswordRepository implements PasswordRepository {
    private final EncryptionService encryptionService;

    private final String FILE_PATH = "src/main/java/org/knit/solutions/task45/passwords.ser";
    private Map<String, PasswordEntry> passwordEntryMap;

    @SneakyThrows({IOException.class, ClassNotFoundException.class})
    @Autowired
    public InMemoryPasswordRepository(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
        try (ObjectInputStream stream = new ObjectInputStream(
                new FileInputStream(FILE_PATH))) {
            String encryptedPasswordEntryMap = (String) stream.readObject();
            passwordEntryMap = encryptionService
                    .getDecryptedPasswordEntryMap(encryptedPasswordEntryMap);
        } catch (EOFException e) {
            passwordEntryMap = new HashMap<>();
        }
    }

    @Override
    public void addPasswordEntry(PasswordEntry passwordEntry) {
        passwordEntryMap.put(passwordEntry.getSite(), passwordEntry);
    }

    @Override
    public void deletePasswordEntry(String site) {
        passwordEntryMap.remove(site);
    }

    @Override
    public PasswordEntry getPasswordEntry(String site) {
        return passwordEntryMap.get(site);
    }

    @Override
    public List<PasswordEntry> getPasswordEntries() {
        return new ArrayList<>(passwordEntryMap.values());
    }

    @SneakyThrows(IOException.class)
    @Override
    public void savePasswordEntries() {
        try (ObjectOutputStream stream = new ObjectOutputStream(
                new FileOutputStream(FILE_PATH))) {
            stream.writeObject(encryptionService
                    .getEncryptedPasswordEntryMap(passwordEntryMap));
        }
    }
}
