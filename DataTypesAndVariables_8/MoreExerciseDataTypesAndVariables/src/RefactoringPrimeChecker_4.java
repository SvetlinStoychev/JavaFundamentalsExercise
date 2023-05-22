import java.util.Scanner;

public class RefactoringPrimeChecker_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int range = Integer.parseInt(reader.nextLine());

        for (int i = 2; i <= range; i++) {

            boolean isPrime = true;

            for (int j = 2; j < i; j++) {

                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, isPrime);
        }
    }
}
