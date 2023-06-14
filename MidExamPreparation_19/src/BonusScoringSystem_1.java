import java.util.Scanner;

public class BonusScoringSystem_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int students = Integer.parseInt(reader.nextLine());
        int lectures = Integer.parseInt(reader.nextLine());
        int initialBonus = Integer.parseInt(reader.nextLine());

        double maxBonusPoints = 0;
        int studentAttendances = 0;

        for (int i = 0; i < students; i++) {
            int currentAttendances = Integer.parseInt(reader.nextLine());
            double currentBonusPoints = currentAttendances * 1.0 / lectures * (5 + initialBonus);

            if (currentBonusPoints > maxBonusPoints) {
                maxBonusPoints = currentBonusPoints;
                studentAttendances = currentAttendances;
            }
        }

        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonusPoints));
        System.out.printf("The student has attended %d lectures.%n", studentAttendances);
    }
}
