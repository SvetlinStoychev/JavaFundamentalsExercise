import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class AsciiSumator_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        char delimiterOne = reader.nextLine().toCharArray()[0];
        char delimiterTwo = reader.nextLine().toCharArray()[0];
        String text = reader.nextLine();

        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) > delimiterOne && text.charAt(i) < delimiterTwo) {
                sum += text.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
