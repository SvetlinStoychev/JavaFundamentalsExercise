import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = 0;

        boolean odd = true;
        while (odd) {
            n = Integer.parseInt(reader.nextLine());
            if (n % 2 == 0) {
                if (n < 0) {
                    n = n * -1;
                }
                System.out.printf("The number is: %d", n);
                odd = false;

            } else {
                System.out.println("Please write an even number.");
            }
        }
    }
}
