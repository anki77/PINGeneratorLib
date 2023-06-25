package org.assessment;

/**
 *  Factory for creating instances of PINGenerator
 */
public final class PINGeneratorFactory {
    private PINGeneratorFactory() {
    }

    /**
     * Creates an instance of PINGenerator
     * @return the instance
     */
    public static PINGenerator createPINGenerator(){
        return new PINGeneratorImpl();
    }
}
