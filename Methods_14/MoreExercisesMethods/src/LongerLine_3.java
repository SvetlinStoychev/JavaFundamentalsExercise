import java.util.Scanner;
public class LongerLine_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int x1 = Integer.parseInt(reader.nextLine());
        int y1 = Integer.parseInt(reader.nextLine());
        int x2 = Integer.parseInt(reader.nextLine());
        int y2 = Integer.parseInt(reader.nextLine());
        int x3 = Integer.parseInt(reader.nextLine());
        int y3 = Integer.parseInt(reader.nextLine());
        int x4 = Integer.parseInt(reader.nextLine());
        int y4 = Integer.parseInt(reader.nextLine());

        double distanceOne = CalculateDistancesFromCenter(x1, y1);
        double distanceTwo = CalculateDistancesFromCenter(x2, y2);
        double distanceThree = CalculateDistancesFromCenter(x3, y3);
        double distanceFour = CalculateDistancesFromCenter(x4, y4);

        double lengthOne = calculateLengthOfLine(x1, x2, y1, y2);
        double lengthTwo = calculateLengthOfLine(x3, x4, y3, y4);

        if (lengthOne > lengthTwo) {

            if (distanceOne < distanceTwo) {
                System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", x2, y2, x1, y1);
            }

        } else if (lengthOne < lengthTwo) {

            if (distanceThree < distanceFour) {
                System.out.printf("(%d, %d)(%d, %d)", x3, y3, x4, y4);
            } else {
                System.out.printf("(%d, %d)(%d, %d)", x4, y4, x3, y3);
            }
        } else {

            System.out.printf("(%d, %d)(%d, %d)", x1, y1, x2, y2);
        }
    }

    private static double calculateLengthOfLine(int x1, int x2, int y1, int y2) {
        double result = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        return result;
    }

    private static double CalculateDistancesFromCenter(int x, int y) {
        double result = Math.sqrt(x * x + y * y);
        return result;
    }
}

