package umbcs680.prime;

import java.util.Iterator;
import java.util.LinkedList;

public class SingletonPrimeGenerator {

    private static SingletonPrimeGenerator instance = null;
    private long from, to;
    private LinkedList<Long> primes = new LinkedList<Long>();

    private SingletonPrimeGenerator() {}

    public static SingletonPrimeGenerator getInstance() {
        if (instance == null) {
            instance = new SingletonPrimeGenerator();
        }
        return instance;
    }

    public void setRange(long from, long to) {
        if (from >= 1 && to > from) {
            this.from = from;
            this.to = to;
            primes.clear(); 
        } else {
            throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
        }
    }

    public LinkedList<Long> getPrimes() {
        return primes;
    }

    protected boolean isEven(long n) {
        return n % 2 == 0;
    }

    protected boolean isPrime(long n){
        // 1 or lower numbers are not prime.
        if(n <= 1){ return false; }   
        // Even numbers are not prime, except for 2. 
        if(n > 2 && isEven(n)){ return false; }
        long i;  
        // Find a number "i" that can divide "n"  
        for (i = (long)Math.sqrt(n); n % i != 0 && i >= 1; i--){}
        // If such a number "i" is found, n is not prime. Otherwise, n is prime.
        if (i == 1){ return true; }
        else{ return false; }
    }
    

    public void generatePrimes() {
        for (long n = from; n <= to; n++) {
            if (isPrime(n)) {
                primes.add(n);
            }
        }
    }

    public static void main(String[] args) {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance();
        gen.setRange(1, 100);
        gen.generatePrimes();
        LinkedList<Long> primes = gen.getPrimes();
        Iterator<Long> it = primes.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", ");
        }
        System.out.println("\n" + gen.getPrimes().size() + " primes are found.");
    }
}
