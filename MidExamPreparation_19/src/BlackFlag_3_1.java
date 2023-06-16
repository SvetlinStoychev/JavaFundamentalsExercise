import java.util.Scanner;

public class BlackFlag_3_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int daysOfPlunder = Integer.parseInt(reader.nextLine());
        int dailyPlunder  = Integer.parseInt(reader.nextLine());
        int expectedPlunder  = Integer.parseInt(reader.nextLine());

        double totalPlunder = 0.0;

        for (int i = 1; i <= daysOfPlunder; i++) {
            totalPlunder += dailyPlunder;

            if (i % 3 == 0) {
                double additionalPlunder = dailyPlunder / 2.0;
                totalPlunder += additionalPlunder;
            }

            if (i % 5 == 0) {
                double losePlunder = totalPlunder - ((totalPlunder * 30) / 100);
                totalPlunder = losePlunder;
            }
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.%n", totalPlunder);
        } else {
            double percentageLeft = (totalPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.%n", percentageLeft);
        }
    }
}
