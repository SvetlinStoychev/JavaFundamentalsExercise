import java.util.Scanner;

public class PrintAndSum_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int start = Integer.parseInt(reader.nextLine());
        int stop = Integer.parseInt(reader.nextLine());

        int sum = 0;
        for (int i = start; i <= stop; i++) {
            sum += i;
            System.out.print(i + " ");
        }

        System.out.printf("%nSum: %d", sum);
    }
}
