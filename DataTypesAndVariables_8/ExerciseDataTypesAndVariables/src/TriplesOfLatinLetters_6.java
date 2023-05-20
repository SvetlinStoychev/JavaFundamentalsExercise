import javax.swing.*;
import java.util.Scanner;

public class TriplesOfLatinLetters_6 {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        for (int firstLetter = 'a'; firstLetter < 'a' + n; firstLetter++) {
            for (int secondLetter = 'a'; secondLetter < 'a' + n; secondLetter++) {
                for (int thirdLetter = 'a'; thirdLetter < 'a' + n; thirdLetter++) {

                    System.out.printf("%c%c%c%n", firstLetter, secondLetter, thirdLetter);
                }
            }
        }
    }
}
