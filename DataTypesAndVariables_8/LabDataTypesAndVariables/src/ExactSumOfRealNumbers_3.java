import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        BigDecimal sum = new BigDecimal(0);
        BigDecimal currentNum = new BigDecimal(0);
        for (int i = 0; i < n; i++) {
            currentNum = reader.nextBigDecimal();
            sum = sum.add(currentNum);
        }

        System.out.println(sum);
    }
}
