package P_thBit_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        int p = Integer.parseInt(reader.nextLine());

        int mask = 1 << p;

        int calc = mask & n;

        int result = calc >> p;
        System.out.println(result);
    }
}
