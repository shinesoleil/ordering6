package com.thoughtworks.ketsu.infrastructure.util;

import org.mindrot.jbcrypt.BCrypt;

public class DefaultEncryptionService {
    public String encrypt(String password) {
        return Encryption.BCRYPT.encrypt(password);
    }

    public boolean check(String checkPassword, String realPassword) {
        return BCrypt.checkpw(checkPassword, realPassword);
    }
}

enum Encryption {
    BCRYPT {
        public String encrypt(String content) {
            return BCrypt.hashpw(content, BCrypt.gensalt(4));
        }

        public boolean check(String input, String hashContent) {
            return BCrypt.checkpw(input, hashContent);
        }
    };

    private Encryption() {
    }

    public abstract String encrypt(String content);

    public abstract boolean check(String input, String hashContent);
}

