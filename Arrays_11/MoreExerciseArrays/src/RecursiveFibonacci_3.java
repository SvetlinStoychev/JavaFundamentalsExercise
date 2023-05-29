import java.util.Scanner;

public class RecursiveFibonacci_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        /*if (n <= 0 || n == 1) {
           n = 2;
        }

        long[] fibonacci = new long[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i = 2; i < fibonacci.length; i++) {

            fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];

        }

        System.out.println(fibonacci[fibonacci.length - 1]);*/

        long result = getFibonacci(n);
        System.out.println(result);
    }

    public static long getFibonacci(int n) {

        if (n <= 2) {
            return 1;
        } else {
            return getFibonacci(n-1) + getFibonacci(n-2);
        }

    }
}
