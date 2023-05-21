import java.util.Scanner;

public class FromLeftToTheRight_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        for (int i = 0; i < n; i++) {
            String input = reader.nextLine();

            String[] inputSplit = input.split(" ");

            long numOne = Long.parseLong(inputSplit[0]);
            long numTwo = Long.parseLong(inputSplit[1]);

            if (numTwo > numOne) {
                numOne = numTwo;
            }

            if (numOne < 0) {
                numOne *= -1;
            }

            int sum = 0;
            while (numOne > 0) {
                sum += numOne % 10;
                numOne /= 10;
            }

            System.out.println(sum);
        }
    }
}
