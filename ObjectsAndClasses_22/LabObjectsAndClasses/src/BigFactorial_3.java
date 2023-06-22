import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        BigInteger f = new BigInteger(String.valueOf(1));

        for (int i = 1; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }

        System.out.println(f);
    }
}
