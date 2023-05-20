import java.util.Scanner;

public class PokeMon_10 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int nPower = Integer.parseInt(reader.nextLine());
        int startPower = nPower;
        int mDistance = Integer.parseInt(reader.nextLine());
        int yExhaustionFactor = Integer.parseInt(reader.nextLine());

        int countOfTargets = 0;

        while (nPower >= mDistance) {
            nPower -= mDistance;
            countOfTargets++;

            if (nPower == startPower / 2) {
                if (yExhaustionFactor != 0) {
                    nPower /= yExhaustionFactor;
                }
            }
        }

        System.out.println(nPower);
        System.out.println(countOfTargets);
    }
}
