package org.assessment.util;

/**
 * Utility class for PINGenerator lib
 */
public class PINGeneratorUtil {


    private PINGeneratorUtil() {
        // hide utility class constructor
    }

    private static int BATCH_SIZE = 1000;
    private static int PIN_LENGTH = 4;

    public static int getBatchSize() {
        return BATCH_SIZE;
    }

    public static int getPinLength() {
        return PIN_LENGTH;
    }
}
