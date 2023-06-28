package Tri_bitSwitch_6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        int p = Integer.parseInt(reader.nextLine());

        int mask = 7 << p;

        int calc = n ^ mask;

        System.out.println(calc);
    }
}
