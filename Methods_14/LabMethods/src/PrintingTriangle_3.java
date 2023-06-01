import java.util.Scanner;

public class PrintingTriangle_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        printTriangle(n);
    }

    public static void printTriangle(int n) {
        for (int i = 1; i <=n ; i++) {
            printLine(i);
        }

        for (int i = n - 1; i >= 1 ; i--) {
            printLine(i);
        }
    }

    public static void printLine(int end) {
        for (int i = 1; i <= end; i++) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
