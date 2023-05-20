import java.util.Scanner;

public class Snowballs_11 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        double highestSnowballValue = 0;
        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;
        for (int i = 0; i < n; i++) {

            int snowballSnow = Integer.parseInt(reader.nextLine());
            int snowballTime = Integer.parseInt(reader.nextLine());
            int snowballQuality = Integer.parseInt(reader.nextLine());

            double snowballValue = Math.pow(((double) snowballSnow / (double) snowballTime), snowballQuality);

            if (snowballValue > highestSnowballValue) {
                highestSnowballValue = snowballValue;
                bestSnowballSnow = snowballSnow;
                bestSnowballTime = snowballTime;
                bestSnowballQuality = snowballQuality;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)", bestSnowballSnow, bestSnowballTime, highestSnowballValue, bestSnowballQuality);
    }
}
