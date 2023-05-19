import java.util.Scanner;

public class CenturiesToMinutes_9 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int centuries = Integer.parseInt(reader.nextLine());

        double years = centuries * 100;
        double days = years * 365.2422;
        double hours = days * 24;
        double minutes = hours * 60;

        System.out.printf("%d centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes",
                centuries, years, days, hours, minutes);
    }
}
