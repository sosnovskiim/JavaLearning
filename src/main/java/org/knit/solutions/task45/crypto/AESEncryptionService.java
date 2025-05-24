package org.knit.solutions.task45.crypto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.knit.solutions.task45.model.PasswordEntry;
import org.knit.solutions.task45.security.MasterPasswordHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class AESEncryptionService implements EncryptionService {
    @Autowired
    private MasterPasswordHolder masterPasswordHolder;

    private final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private final byte[] salt = "[B@61fe30".getBytes();

    @SneakyThrows({NoSuchAlgorithmException.class, InvalidKeySpecException.class})
    private SecretKey getKeyFromMasterPassword() {
        KeySpec spec = new PBEKeySpec(masterPasswordHolder.getMasterPassword(),
                salt, 65536, 256);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(
                "PBKDF2WithHmacSHA256");
        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
    }

    @SneakyThrows({NoSuchPaddingException.class, NoSuchAlgorithmException.class,
            InvalidAlgorithmParameterException.class, InvalidKeyException.class,
            IllegalBlockSizeException.class, BadPaddingException.class})
    @Override
    public String getEncryptedPassword(String password) {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, getKeyFromMasterPassword(),
                new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return Base64.getEncoder().encodeToString(
                cipher.doFinal(password.getBytes()));
    }

    @SneakyThrows({NoSuchPaddingException.class, NoSuchAlgorithmException.class,
            InvalidAlgorithmParameterException.class, InvalidKeyException.class,
            IllegalBlockSizeException.class, BadPaddingException.class})
    @Override
    public String getDecryptedPassword(String encryptedPassword) {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, getKeyFromMasterPassword(),
                new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return new String(cipher.doFinal(
                Base64.getDecoder().decode(encryptedPassword)));
    }

    @SneakyThrows({NoSuchPaddingException.class, NoSuchAlgorithmException.class,
            InvalidAlgorithmParameterException.class, InvalidKeyException.class,
            IllegalBlockSizeException.class, BadPaddingException.class,
            JsonProcessingException.class})
    @Override
    public String getEncryptedPasswordEntryMap(
            Map<String, PasswordEntry> passwordEntryMap) {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, getKeyFromMasterPassword(),
                new IvParameterSpec(new byte[cipher.getBlockSize()]));
        String jsonString = new ObjectMapper().writeValueAsString(passwordEntryMap);
        return Base64.getEncoder().encodeToString(
                cipher.doFinal(jsonString.getBytes()));
    }

    @SneakyThrows({NoSuchPaddingException.class, NoSuchAlgorithmException.class,
            InvalidAlgorithmParameterException.class, InvalidKeyException.class,
            IllegalBlockSizeException.class, BadPaddingException.class,
            JsonProcessingException.class})
    @Override
    public Map<String, PasswordEntry> getDecryptedPasswordEntryMap(
            String encryptedPasswordEntryMap) {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, getKeyFromMasterPassword(),
                new IvParameterSpec(new byte[cipher.getBlockSize()]));
        String jsonString = new String(cipher.doFinal(
                Base64.getDecoder().decode(encryptedPasswordEntryMap)));
        Map<String, PasswordEntry> passwordEntryMap = new ObjectMapper().readValue(
                jsonString, new TypeReference<HashMap<String, PasswordEntry>>() {
                });
        return Objects.requireNonNullElseGet(passwordEntryMap, HashMap::new);
    }
}
