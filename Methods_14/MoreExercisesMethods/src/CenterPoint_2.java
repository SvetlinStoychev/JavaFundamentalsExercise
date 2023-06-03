import java.util.Scanner;

public class CenterPoint_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int x1 = Integer.parseInt(reader.nextLine());
        int y1 = Integer.parseInt(reader.nextLine());
        int x2 = Integer.parseInt(reader.nextLine());
        int y2 = Integer.parseInt(reader.nextLine());

        printClosestPoint(x1, y1, x2, y2);
    }

    private static void printClosestPoint(int x1, int y1, int x2, int y2) {
        double distOne = calculateDistance(x1, y1);
        double distTwo = calculateDistance(x2 ,y2);

        if (distOne <= distTwo) {
            System.out.printf("(%d, %d)", x1, y1);
        } else {
            System.out.printf("(%d, %d)", x2, y2);
        }
    }

    private static double calculateDistance(int x, int y) {
        double result = Math.sqrt(x * x + y * y);
        return result;
    }
}
