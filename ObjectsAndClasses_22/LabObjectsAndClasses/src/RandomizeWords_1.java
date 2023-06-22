import java.util.Random;
import java.util.Scanner;

public class RandomizeWords_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] words = reader.nextLine().split(" ");

        Random rnd = new Random();

        for (int i = 0; i < words.length; i++) {
            int newPoss = rnd.nextInt(words.length);

            String temp = words[i];
            words[i] = words[newPoss];
            words[newPoss] = temp;
        }

        System.out.println(String.join(System.lineSeparator(), words));
    }
}
