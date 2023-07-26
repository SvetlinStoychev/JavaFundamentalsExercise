import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_2_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String foodInfo = reader.nextLine();
        String regex = "([\\|\\#])(?<name>[A-Za-z\\s]+)\\1(?<date>[\\d]{2}\\/[\\d]{2}\\/[\\d]{2})\\1(?<calories>[\\d]+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(foodInfo);

        int totalCalories = 0;

        while (matcher.find()) {
            totalCalories += Integer.parseInt(matcher.group("calories"));
        }

        System.out.printf("You have food to last you for: %d days!%n", (totalCalories / 2000));

        matcher.reset();
        while (matcher.find()) {
            String item = matcher.group("name");
            String date = matcher.group("date");
            String calories = matcher.group("calories");

            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", item, date, calories);
        }
    }
}
