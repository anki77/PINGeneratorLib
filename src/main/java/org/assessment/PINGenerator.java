package org.assessment;

import java.util.List;

/**
 *  An interface for generating PINs.
 */
public interface PINGenerator {

    /**
     * A method to return a batch of 1000, randomly generated, unique 4 digit PINs.
     *
     * @return A list of 1000 unique 4 digit PINs.
     */
    public List<String> generatePinBatch();
}
