package BinaryDigitsCount_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int number = Integer.parseInt(reader.nextLine());
        int digit = Integer.parseInt(reader.nextLine());

        int cnt = 0;

        while (number > 0) {
            int currentDigit = number % 2;

            if (currentDigit == digit) {
                cnt++;
            }

            number /= 2;
        }

        System.out.println(cnt);
    }
}
