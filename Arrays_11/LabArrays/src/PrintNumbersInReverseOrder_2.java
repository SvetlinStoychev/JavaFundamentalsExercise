import java.util.Scanner;

public class PrintNumbersInReverseOrder_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        int[] numArr = new int[n];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(reader.nextLine());
        }

        for (int i = numArr.length - 1; i >= 0; i--) {
            System.out.printf("%d ", numArr[i]);
        }
    }
}
