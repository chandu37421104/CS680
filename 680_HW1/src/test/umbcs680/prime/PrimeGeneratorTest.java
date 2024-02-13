package umbcs680.prime;

import static org.junit.Assert.*;
import org.junit.Test;

import java.beans.Transient;
import java.util.LinkedList;

public class PrimeGeneratorTest {

    @Test(expected = RuntimeException.class)
    public void InvalidRangeFrom25To13() {
        new PrimeGenerator(25, 13);
    }

    @Test
    public void Is60Even() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertTrue("60 should be even", gen.isEven(60));
    }

    @Test
    public void Is31Even() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertFalse("31 should not be even", gen.isEven(31));
    }

    @Test
    public void Is2Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertTrue("2 is prime", gen.isPrime(2));
    }

    @Test
    public void Is31Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertTrue("31 is prime", gen.isPrime(31));
    }

    @Test
    public void Is53Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertTrue("53 is prime", gen.isPrime(53));
    }
    
    @Test
    public void Is67Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertTrue("67 is prime", gen.isPrime(67));
    }

    @Test
    public void Is1Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertFalse("1 is not prime", gen.isPrime(1));
    }

    @Test
    public void Is40Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertFalse("40 is not prime", gen.isPrime(40));
    }

    @Test
    public void Is99Prime() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        assertFalse("99 is not prime", gen.isPrime(99));
    }


    @Test
    public void testGeneratePrimes() {
        PrimeGenerator gen = new PrimeGenerator(1, 100);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
        assertArrayEquals("Primes between 1 and 100", expectedPrimes, primes.toArray(new Long[0]));
    }
}
