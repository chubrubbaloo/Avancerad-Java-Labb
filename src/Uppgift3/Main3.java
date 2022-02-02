package Uppgift3;


import java.util.List;
import java.util.regex.Pattern;

public class Main3 {

    public static void main(String[] args) {

        // Enbart engelska vokaler och stora eller små bokstäver spelar ej någon roll.
        Pattern pattern2 = Pattern.compile("[aeiouy]", Pattern.CASE_INSENSITIVE);

        // Listan med ord.
        List<String> words = List.of("hej", "psst", "bil", "brr", "yxa");
        System.out.println(words);
        System.out.println("----");

        // Filtrerar listan enbart med de godkända orden och är åtminstone två bokstäver långa.
        words
                .stream()
                .filter(strLength -> strLength.length() >= 2)
                .filter(word -> pattern2.matcher(word).find())
                .forEach(System.out::println);
    }

}


