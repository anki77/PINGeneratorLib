package org.assessment;


import org.assessment.util.PINGeneratorUtil;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PINGeneratorImplTest {

    private PINGenerator generator;

    @BeforeEach
    public void setUp(){
        generator  = new PINGeneratorImpl();
    }

    @AfterAll
    public static void  cleanUp(){
        Mockito.framework().clearInlineMocks();
    }
    @Test
    public void testGeneratePinBatch() {

        List<String> pinBatch = generator.generatePinBatch();

        // Verify that the generated PINs are unique
        Assertions.assertEquals(pinBatch.size(), new HashSet<>(pinBatch).size());

        // Verify that the generated PINs have the correct length
        for (String pin : pinBatch) {
            Assertions.assertEquals(PINGeneratorUtil.getPinLength(), pin.length());
        }

        // Verify that the number of generated PINs matches the batch size
        Assertions.assertEquals(PINGeneratorUtil.getBatchSize(), pinBatch.size());

        // Verify that the generated PINs contain only numeric characters
        for (String pin : pinBatch) {
            Assertions.assertTrue(pin.matches("\\d+"));
        }
    }

    @Test
    public void testGeneratePinBatchWithInvalidLength() {

        try (MockedStatic<PINGeneratorUtil> utilities = Mockito.mockStatic(PINGeneratorUtil.class)) {
            utilities.when(PINGeneratorUtil::getPinLength).thenReturn(-1);
            utilities.when(PINGeneratorUtil::getBatchSize).thenReturn(1000);
            // Verify that generatePinBatch() returns an empty list
            List<String> pins = generator.generatePinBatch();
            assertEquals(0, pins.size());
        }
    }
}
