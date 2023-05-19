import java.util.Scanner;

public class PoundsToDollars_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        double britishPound = Double.parseDouble(reader.nextLine());

        double dollar = britishPound *  1.36;

        System.out.printf("%.3f", dollar);
    }
}
