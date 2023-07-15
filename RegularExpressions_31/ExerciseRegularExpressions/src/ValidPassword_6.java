import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPassword_6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        for (int i = 0; i < n; i++) {
            String input = reader.nextLine();

            String regex = "(_\\.+)([A-Z][a-zA-Z0-9]{4,}[A-Z])(_\\.+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String digitRegex = "\\d";
                pattern = Pattern.compile(digitRegex);
                matcher = pattern.matcher(input);

                if (matcher.find()) {
                    matcher.reset();
                    StringBuilder digitsSb = new StringBuilder();
                    while (matcher.find()) {
                        digitsSb.append(matcher.group());
                    }
                    System.out.println("Group: " + digitsSb);
                } else {
                    System.out.println("Group: default");
                }
            } else {
                System.out.println("Invalid pass!");
            }
        }
    }
}
