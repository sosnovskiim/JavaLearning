package org.knit.solutions.task45.crypto;

import org.knit.solutions.task45.model.PasswordEntry;

import java.util.Map;

public interface EncryptionService {
    String getEncryptedPassword(String password);

    String getDecryptedPassword(String encryptedPassword);

    String getEncryptedPasswordEntryMap(
            Map<String, PasswordEntry> passwordEntryMap);

    Map<String, PasswordEntry> getDecryptedPasswordEntryMap(
            String encryptedPasswordEntryMap);
}
