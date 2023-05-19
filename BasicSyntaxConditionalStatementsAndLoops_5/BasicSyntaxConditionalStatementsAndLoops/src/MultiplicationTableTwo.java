import java.util.Scanner;

public class MultiplicationTableTwo {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        int times = Integer.parseInt(reader.nextLine());

        if (times < 10) {
            for (int i = times; i <= 10; i++) {
                System.out.printf("%d X %d = %d%n", n, i, n*i);
            }
        } else {
            System.out.printf("%d X %d = %d%n", n, times, n*times);
        }
    }
}
