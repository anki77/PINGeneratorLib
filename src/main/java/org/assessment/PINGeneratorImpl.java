package org.assessment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assessment.util.PINGeneratorUtil;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Implement the method of PINGenerator
 */
public class PINGeneratorImpl implements PINGenerator{

    PINGeneratorImpl(){}

    private static final Logger LOG = LogManager.getLogger(PINGeneratorImpl.class);

    /**
     * A method to return a batch of 1000, randomly generated, unique 4 digit PINs
     * @return List<String>
     */
    @Override
    public List<String> generatePinBatch() {
        HashSet<String> pins = new HashSet<>();
        for (int i = 0; i < PINGeneratorUtil.getBatchSize(); i++) {
            String pin = generatePin();
            while (pins.contains(pin)) {
                pin = generatePin();
            }
            if (pin!= null)
                pins.add(pin);
            else
                break;
        }
        return new ArrayList<>(pins);
    }

    private String generatePin() {
        SecureRandom random = new SecureRandom();
        try {
            int pin = random.nextInt((int) Math.pow(10, PINGeneratorUtil.getPinLength()));
            return String.format("%0" + PINGeneratorUtil.getPinLength() + "d", pin);
        }
        catch (IllegalArgumentException e) {
            // Handle exception if the PIN_LENGTH is invalid for the random number generation
            LOG.error("Error: Invalid PIN_LENGTH. PIN generation failed. " + e.getMessage());
            return null; // Or throw a custom exception, return a default value, etc.
        } catch (Exception e) {
            // Handle any other unexpected exception
            LOG.error("Error: An unexpected error occurred during PIN generation. "+ e.getMessage());
            return null; // Or throw a custom exception, return a default value, etc.
        }
    }
}
