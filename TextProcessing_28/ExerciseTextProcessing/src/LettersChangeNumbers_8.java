import java.util.Scanner;
import java.util.Spliterator;

public class LettersChangeNumbers_8 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();
        String[] inputArr = input.split("\\s+");

        double totalSum = 0.0;

        for (int i = 0; i < inputArr.length; i++) {
            totalSum += changeNumber(inputArr[i]);
        }

        System.out.printf("%.2f", totalSum);
    }

    private static double changeNumber(String s) {
        char  letterBefore = s.charAt(0);
        char  letterAfter = s.charAt(s.length() - 1);

        double number = Double.parseDouble(s.replace(letterBefore, ' ')
                .replace(letterAfter, ' ')
                .trim());

        if (Character.isUpperCase(letterBefore)) {
            int letterPosition = (int)letterBefore - 64;
            number /= letterPosition;
        } else {
            int letterPosition = (int) letterBefore - 96;
            number *= letterPosition;
        }

        if (Character.isUpperCase(letterAfter)) {
            int letterPosition = (int) letterAfter - 64;
            number -= letterPosition;
        } else {
            int letterPosition = (int) letterAfter - 96;
            number += letterPosition;
        }

        return number;
    }
}
