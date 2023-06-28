package BitAtPosition1_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        int mask = 1 << 1;

        int calc = mask & n;

        int result = calc >> 1;
        System.out.println(result);
    }
}
