package umbcs680.prime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SingletonPrimeGeneratorTest {

    @Test
    public void GetInstanceReturnsNonNullValue() {
        assertNotNull(SingletonPrimeGenerator.getInstance(), "Instance should not be null");
    }

    @Test
    public void GetInstanceReturnsIdenticalInstance() {
        SingletonPrimeGenerator instance1 = SingletonPrimeGenerator.getInstance();
        SingletonPrimeGenerator instance2 = SingletonPrimeGenerator.getInstance();
        assertSame(instance1, instance2, "Both instances should be the same");
    }

    @Test
    public void GetPrimesReturnsExpectedPrimeNumbers() {
        SingletonPrimeGenerator instance = SingletonPrimeGenerator.getInstance();
        instance.setRange(1, 100);
        instance.generatePrimes();
        assertIterableEquals(java.util.Arrays.asList(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L), instance.getPrimes(), "The prime numbers between 1 and 10 are 2, 3, 5, 7");
    }

    @Test
    public void SetRangeWithInvalidRangeValues() {
        SingletonPrimeGenerator instance = SingletonPrimeGenerator.getInstance();
        assertThrows(RuntimeException.class, () -> instance.setRange(-10, 10), "Expected an exception for the range [-10, 10]");
        assertThrows(RuntimeException.class, () -> instance.setRange(-10, -5), "Expected an exception for the range [-10, -5]");
        assertThrows(RuntimeException.class, () -> instance.setRange(100, 1), "Expected an exception for the range [100, 1]");
    }
}
