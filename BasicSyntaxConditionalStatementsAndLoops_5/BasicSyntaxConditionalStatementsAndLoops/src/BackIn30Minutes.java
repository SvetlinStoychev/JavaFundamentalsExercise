import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int hour = Integer.parseInt(reader.nextLine());
        int minute = Integer.parseInt(reader.nextLine());

        minute = minute + 30;
        if (minute > 59) {
            hour++;
            if (hour > 23) {
                hour = 0;
            }
            minute = minute - 60;
        }

        System.out.printf("%d:%02d", hour, minute);
    }
}
