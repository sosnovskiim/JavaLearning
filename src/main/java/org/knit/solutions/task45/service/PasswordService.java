package org.knit.solutions.task45.service;

import lombok.extern.slf4j.Slf4j;
import org.knit.solutions.task45.clipboard.ClipboardService;
import org.knit.solutions.task45.crypto.EncryptionService;
import org.knit.solutions.task45.model.PasswordEntry;
import org.knit.solutions.task45.repository.PasswordRepository;
import org.knit.solutions.task45.security.MasterPasswordHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class PasswordService {
    @Autowired
    private MasterPasswordHolder masterPasswordHolder;
    @Autowired
    private PasswordRepository passwordRepository;
    @Autowired
    private EncryptionService encryptionService;
    @Autowired
    private ClipboardService clipboardService;

    public boolean isMasterPasswordCorrect(char[] masterPassword) {
        return Arrays.equals(masterPassword, masterPasswordHolder.getMasterPassword());
    }

    public String addPasswordEntry(String site, String login, String password) {
        if (passwordRepository.getPasswordEntry(site) != null) {
            log.error("Запись о сайте \"{}\" уже существует.", site);
            return "Запись уже существует.";
        }
        String encryptedPassword = encryptionService.getEncryptedPassword(password);
        PasswordEntry passwordEntry = new PasswordEntry(site, login, encryptedPassword);
        passwordRepository.addPasswordEntry(passwordEntry);
        log.info("Запись о сайте \"{}\" успешно добавлена.", site);
        return "Запись успешно добавлена.";
    }

    public List<PasswordEntry> getPasswordEntries() {
        return passwordRepository.getPasswordEntries();
    }

    public String copyPasswordToClipboard(String site) {
        if (passwordRepository.getPasswordEntry(site) == null) {
            log.error("Запись о сайте \"{}\" не существует.", site);
            return "Запись не существует.";
        }
        PasswordEntry passwordEntry = passwordRepository.getPasswordEntry(site);
        String password = encryptionService.getDecryptedPassword(passwordEntry.getEncryptedPassword());
        clipboardService.copyPasswordToClipboard(password);
        log.info("Запись о сайте \"{}\" успешно скопирована.", site);
        return "Запись успешно скопирована.";
    }

    public String deletePasswordEntry(String site) {
        if (passwordRepository.getPasswordEntry(site) == null) {
            log.error("Запись о сайте \"{}\" не существует.", site);
            return "Запись не существует.";
        }
        passwordRepository.deletePasswordEntry(site);
        log.info("Запись о сайте \"{}\" успешно удалена.", site);
        return "Запись успешно удалена.";
    }

    public void clearMasterPassword() {
        masterPasswordHolder.clearMasterPassword();
    }

    public void savePasswordEntries() {
        passwordRepository.savePasswordEntries();
    }
}
