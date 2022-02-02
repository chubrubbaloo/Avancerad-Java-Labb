package Uppgift4;


import java.util.ArrayList;
import java.util.List;


public class Main4 {

    public static void main(String[] args)  {



        // Lista som primtalen kommer att sparas i.
        List<Integer> onlyPrimeNumbers = new ArrayList<>();

        // Lambdatråd 1 som loopar igenom från 2-350_000 då 0 och 1 per automatik inte är primtal
        // och addar sedan primtalen till listan.
        Thread threadOne = new Thread(() -> {
            int i, j, count = 0;
            for (i = 2; i <= 350_000; i++) {
                for (j = 1; j <= i; j++) {
                    if (i % j == 0)
                        count++;
                }
                if (count == 2)
                    onlyPrimeNumbers.add(i);
                count = 0;
            }
        });


        // Lambdatråd 2 som har samma logik som ovan fast räknar från 350_001 till 500_000, adderar till listan och
        // printar ut antalet primtal.
        Thread threadTwo = new Thread(() -> {
            int i, j, count = 0;
            for (i = 350_001; i <= 500_000; i++) {
                for (j = 1; j <= i; j++) {
                    if (i % j == 0)
                        count++;
                }
                if (count == 2)
                    onlyPrimeNumbers.add(i);
                count = 0;
            }
            System.out.println("Trådarna innehåller " + onlyPrimeNumbers.size() + " primtal");
        });

        // Startar båda trådarna.
        // Extremt ineffektiv, men ska ge ett resultat på 41538.
        threadOne.start();
        threadTwo.start();


    }
}