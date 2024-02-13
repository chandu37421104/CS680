package umbcs680.prime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

public class PrimeGeneratorTest {

    @Test
    void InvalidRangeFrom25To13() {
        assertThrows(RuntimeException.class, () -> new PrimeGenerator(25, 13));
    }

    @Test
    void Is60Even() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertTrue(gen.isEven(60), "60 should be even");
    }

    @Test
    void Is31Even() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertFalse(gen.isEven(31), "31 should not be even");
    }

    @Test
    void Is2Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertTrue(gen.isPrime(2), "2 is prime");
    }

    @Test
    void Is31Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertTrue(gen.isPrime(31), "31 is prime");
    }

    @Test
    void Is53Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertTrue(gen.isPrime(53), "53 is prime");
    }
    
    @Test
    void Is67Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertTrue(gen.isPrime(67), "67 is prime");
    }

    @Test
    void Is1Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertFalse(gen.isPrime(1), "1 is not prime");
    }

    @Test
    void Is40Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertFalse(gen.isPrime(40), "40 is not prime");
    }

    @Test
    void Is99Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertFalse(gen.isPrime(99), "99 is not prime");
    }

    @Test
    void GeneratePrimesFrom1To100() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
        assertArrayEquals(expectedPrimes, primes.toArray(new Long[0]), "Primes between 1 and 100");
    }
}
