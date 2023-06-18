import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int biscuitsPerDay = Integer.parseInt(reader.nextLine());
        int workersCnt = Integer.parseInt(reader.nextLine());
        int competingNumOfBiscuits = Integer.parseInt(reader.nextLine());

        double usualProductionPerDay = biscuitsPerDay * workersCnt;
        double totalProduction = 0;

        for (int i = 1; i <= 30; i++) {
            if (i % 3 == 0) {
                double thirdDayProduction = Math.floor((usualProductionPerDay * 75) / 100);
                totalProduction += thirdDayProduction;
            } else {
                totalProduction += usualProductionPerDay;
            }
        }

        System.out.printf("You have produced %.0f biscuits for the past month.%n", totalProduction);

        if (totalProduction > competingNumOfBiscuits) {
            double differencesInProduction = totalProduction - competingNumOfBiscuits;
            double percent = (differencesInProduction / competingNumOfBiscuits) * 100;
            System.out.printf("You produce %.2f percent more biscuits.%n", percent);
        } else {
            double differencesInProduction = competingNumOfBiscuits - totalProduction;
            double percent = (differencesInProduction / competingNumOfBiscuits) * 100;
            System.out.printf("You produce %.2f percent less biscuits.%n", percent);
        }
    }
}
