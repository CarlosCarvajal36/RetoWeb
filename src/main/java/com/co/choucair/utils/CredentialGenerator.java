package com.co.choucair.utils;

import java.util.Random;

public final class CredentialGenerator {

    private CredentialGenerator() {
        throw new UnsupportedOperationException("Utility utility class - cannot be instantiated");
    }

    public static String generateUniqueUsername(String prefix) {
        int randomSuffix = new Random().nextInt(9000) + 1000; // Número aleatorio de 4 cifras (1000 - 9999)
        return prefix + "_" + System.currentTimeMillis() + "_" + randomSuffix;
    }
}