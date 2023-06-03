import java.util.Scanner;

public class FactorialDivision_8 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int first = Integer.parseInt(reader.nextLine());
        int second = Integer.parseInt(reader.nextLine());

        double firstFactorial = calculateFactorial(first);
        double secondFactorial = calculateFactorial(second);

        double result = firstFactorial / secondFactorial;
        System.out.printf("%.2f", result);
    }

    public static long calculateFactorial(int n) {
        long factorial = 1;
        for (int i = 1; i <= n ; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
