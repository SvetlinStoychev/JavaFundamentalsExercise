import java.util.Scanner;

public class TownInfo_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String nameTown = reader.nextLine();
        int population = Integer.parseInt(reader.nextLine());
        int area = Integer.parseInt(reader.nextLine());

        System.out.printf("Town %s has population of %d and area %d square km.", nameTown, population, area);
    }
}
