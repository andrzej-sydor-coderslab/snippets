package com.example.bcryptgeneratepassword;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptGeneratePasswordApplication {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        System.out.println(hashedPassword);
    }

}
