package Uppgift4;


import java.util.ArrayList;
import java.util.List;


public class Main4 {

    public static void main(String[] args) throws InterruptedException {


        // Lista som primtalen kommer att sparas i.
        List<Integer> prime = new ArrayList<>();

        // Lambdatråd 1 som loopar igenom från 0-350_000 och adderar primtalen till listan.
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i <= 350_000; i++) {
                if (isPrime(i)) {
                    prime.add(i);
                }
            }
        }
        );

        // Lambdatråd 2 som har samma logik som ovan fast räknar från 350_001 till 500_000, adderar till listan och
        Thread threadTwo = new Thread(() -> {
            for (int i = 350_001; i <= 500_000; i++) {
                if (isPrime(i)) {
                    prime.add(i);
                }
            }
            System.out.println(prime.size());
        }
        );

        // Triggar trådarna.
        threadOne.start();
        threadOne.join();
        threadTwo.start();


    }


    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}