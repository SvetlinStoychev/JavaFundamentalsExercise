import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String inputText = reader.nextLine();

        String regex = "\\|([A-Za-z\\s]+)\\|(\\d{2}\\/\\d{2}\\/\\d{2})\\|(\\d{1,5})\\||\\#([A-Za-z\\s]+)\\#(\\d{2}\\/\\d{2}\\/\\d{2})\\#(\\d{1,5})\\#";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);

        String hashRegex = "\\#(?<name>[A-Za-z\\s]+)\\#(?<data>\\d{2}\\/\\d{2}\\/\\d{2})\\#(?<calories>\\d{1,5})\\#";
        String pipeRegex = "\\|(?<name>[A-Za-z\\s]+)\\|(?<data>\\d{2}\\/\\d{2}\\/\\d{2})\\|(?<calories>\\d{1,5})\\|";
        Pattern hashPattern = Pattern.compile(hashRegex);
        Pattern pipePattern = Pattern.compile(pipeRegex);
        Matcher hashMatcher = hashPattern.matcher(inputText);
        Matcher pipeMatcher = pipePattern.matcher(inputText);

        int totalCalories = 0;

        while (hashMatcher.find()) {
            totalCalories += Integer.parseInt(hashMatcher.group("calories"));
        }

        while (pipeMatcher.find()) {
            totalCalories += Integer.parseInt(pipeMatcher.group("calories"));
        }

        int foodToLast = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!%n", foodToLast);

        while (matcher.find()) {
            String currentFoodInfo = matcher.group();

            if (currentFoodInfo.contains("#")) {
                hashMatcher = hashPattern.matcher(currentFoodInfo);
                while (hashMatcher.find()) {
                    String name = hashMatcher.group("name");
                    String data = hashMatcher.group("data");
                    String calories = hashMatcher.group("calories");

                    System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", name, data, calories);
                }
            } else if (currentFoodInfo.contains("|")) {
                pipeMatcher = pipePattern.matcher(currentFoodInfo);
                while (pipeMatcher.find()) {
                    String name = pipeMatcher.group("name");
                    String data = pipeMatcher.group("data");
                    String calories = pipeMatcher.group("calories");

                    System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", name, data, calories);
                }
            }
        }
    }
}
