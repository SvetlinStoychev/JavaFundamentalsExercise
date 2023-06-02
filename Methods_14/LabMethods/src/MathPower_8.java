import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower_8 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        double inputNum = Double.parseDouble(reader.nextLine());
        int power = Integer.parseInt(reader.nextLine());

        DecimalFormat df = new DecimalFormat("0.####");

        double result = mathPower(inputNum, power);
        System.out.println(df.format(result));
    }

    public static double mathPower(double num, int power) {
        double result = 1;
        for (int i = 0; i < power; i++) {
            result  *= num;
        }
        return result;
    }
}
