package org.assessment;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Implement the method of PINGenerator
 */
public class PINGeneratorImpl implements PINGenerator{

    PINGeneratorImpl(){}

    /**
     * A method to return a batch of 1000, randomly generated, unique 4 digit PINs
     * @return List<String>
     */
    @Override
    public List<String> generatePinBatch() {
        HashSet<String> pins = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            String pin = generatePin();
            while (pins.contains(pin)) {
                pin = generatePin();
            }
            pins.add(pin);
        }
        return new ArrayList<>(pins);
    }

    private String generatePin() {
        SecureRandom random = new SecureRandom();
            int pin = random.nextInt(10000);
            return String.format("%04d", pin);
    }
}
