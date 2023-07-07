import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String bigNumberStr = reader.nextLine();
        String singleDigitStr = reader.nextLine();

        BigInteger bigNumber = new BigInteger(bigNumberStr);
        BigInteger singleDigit = new BigInteger(singleDigitStr);

        BigInteger result = bigNumber.multiply(singleDigit);

        System.out.println(result);
    }
}