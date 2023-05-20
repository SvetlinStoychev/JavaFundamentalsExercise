import java.util.Scanner;

public class WaterOverflow_7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(reader.nextLine());

        int litersInTank = 0;
        for (int i = 0; i < numberOfLines; i++) {
            int quantitie = Integer.parseInt(reader.nextLine());

            if (quantitie + litersInTank > 255) {
                System.out.println("Insufficient capacity!");
            } else {
                litersInTank += quantitie;
            }
        }

        System.out.println(litersInTank);
    }

}
