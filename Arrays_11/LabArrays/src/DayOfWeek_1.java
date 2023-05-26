import java.util.Scanner;

public class DayOfWeek_1 {
    public static void main(String[] args) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        Scanner reader = new Scanner(System.in);

        int numToDay = Integer.parseInt(reader.nextLine());

        if (numToDay >= 1 && numToDay <= 7) {
            System.out.println(daysOfWeek[numToDay - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
