package Uppgift4;


// Så att vi kan få tillgång till våran statiska vektor utan att skapa objekt så importerar vi det till detta dokumentet.
import static Uppgift4.Main4.staticIntArray;

class PrimeNumbers implements Runnable {

    int start;
    int end;
    int primeOnly;

    public PrimeNumbers(int start, int end, int primeOnly) {
        this.start = start;
        this.end = end;
        this.primeOnly = primeOnly;
    }

    @Override
    public void run() {
        // Loopar igenom start och slutvärdet på våra trådar.
        for (int i = start; i <= end; i++) {
            boolean isPrime = true;

            // OM vi inte får ut ett primtal så är vårt booleanska värde falskt.
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            // OM det är ett primtal så lägger vi in primtalet i vår statiska vektor.
            if (isPrime) {
                staticIntArray[primeOnly]++;
            }
        }
    }
}

public class Main4 {

    // Sparar våra primtal i vår statiska vektor.
    public static Integer[] staticIntArray = {0, 0};

    public static void main(String[] args) throws InterruptedException {

        // Primtal är alltid större än 1 så vi startar på två direkt.
        // Delar upp det i två trådar.
        PrimeNumbers primeNumbersOne = new PrimeNumbers(2, 350_000, 0);
        Thread threadOne = new Thread(primeNumbersOne);
        PrimeNumbers primeNumbersTwo = new PrimeNumbers(350_001, 500_000, 1);
        Thread threadTwo = new Thread(primeNumbersTwo);

        // Startar trådarna.
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();

        // Printar resultaten.
        System.out.println("Primtal: " + (staticIntArray[0] + staticIntArray[1]));

    }
}
