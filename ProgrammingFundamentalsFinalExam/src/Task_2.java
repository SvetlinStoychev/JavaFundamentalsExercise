import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String text = reader.nextLine();
        String regex = "([@#]+)(?<color>[a-z]{3,})([@#]+)(\\W*)([\\/]+)(?<amount>[\\d]+)([\\/]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String amount = matcher.group("amount");
            String color = matcher.group("color");

            System.out.printf("You found %s %s eggs!%n", amount, color);
        }
    }
}
