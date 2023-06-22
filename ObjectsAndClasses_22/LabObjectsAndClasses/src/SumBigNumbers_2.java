import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        BigInteger firstNum = new BigInteger(reader.nextLine());
        BigInteger secondNum = new BigInteger(reader.nextLine());

        BigInteger sum = firstNum.add(secondNum);

        System.out.println(sum);

    }
}
