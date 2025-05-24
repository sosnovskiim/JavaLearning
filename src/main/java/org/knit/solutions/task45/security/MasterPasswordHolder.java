package org.knit.solutions.task45.security;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class MasterPasswordHolder {
    private char[] masterPassword = new char[]{'m', 'a', 's', 't', 'e', 'r'};

    public void clearMasterPassword() {
        masterPassword = new char[0];
    }
}
