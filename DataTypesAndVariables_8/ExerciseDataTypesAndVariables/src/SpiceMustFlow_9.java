import java.util.Scanner;

public class SpiceMustFlow_9 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int startingYield = Integer.parseInt(reader.nextLine());

        int  daysOperated = 0;
        int totalAmountOfSpice = 0;

        while (startingYield >= 100) {

            int dayAmount = startingYield - 26;
            totalAmountOfSpice += dayAmount;
            daysOperated++;
            startingYield -= 10;

        }

        if (daysOperated != 0) {
            totalAmountOfSpice -= 26;
            System.out.println(daysOperated);
            System.out.println(totalAmountOfSpice);
        } else {
            System.out.println(daysOperated);
            System.out.println(totalAmountOfSpice);
        }
    }
}
