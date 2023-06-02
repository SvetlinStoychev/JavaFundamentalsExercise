import java.util.Scanner;

public class MultiplyEvensByOdds_10 {
    static public int evenSum = 0;
    static public int oddSum = 0;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int input = Math.abs(Integer.parseInt(reader.nextLine()));

        int result = getMultipleOfEvensAndOdds(input);

        System.out.println(result);
    }

    public static int getMultipleOfEvensAndOdds(int num) {
        while (num > 0) {
            int currNum = num % 10;
            if (currNum % 2 == 0) {
                getEvenSum(currNum);
            } else {
                getOddSum(currNum);
            }
            num /= 10;
        }
        return evenSum * oddSum;
    }

    public static void getEvenSum(int num) {
        evenSum += num;
    }

    public static void getOddSum(int num) {
        oddSum += num;
    }
}
