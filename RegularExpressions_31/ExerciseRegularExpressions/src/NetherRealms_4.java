import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();
        String inputRegex = "[,\\s]+";
        String[] inputArr = input.split(inputRegex);

        for (int i = 0; i < inputArr.length; i++) {
            String healthRegex = "[^\\d\\+\\-\\*\\/\\.]";
            Pattern healthPattern = Pattern.compile(healthRegex);
            Matcher healthMatcher = healthPattern.matcher(inputArr[i]);

            int health = 0;

            while (healthMatcher.find()) {
                char currentChar = healthMatcher.group().charAt(0);
                health += currentChar;
            }

            String damageRegex = "\\+?\\-?\\d+\\.?\\d*";
            Pattern damagePattern = Pattern.compile(damageRegex);
            Matcher damageMatcher = damagePattern.matcher(inputArr[i]);

            double damage = 0.0;

            while (damageMatcher.find()) {
                double currentDamage = Double.parseDouble(damageMatcher.group());
                damage += currentDamage;
            }

            String regex = "[\\*?\\/?]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputArr[i]);

            while (matcher.find()) {
                if (matcher.group().equals("*")){
                    damage *= 2;
                } else if (matcher.group().equals("/")) {
                    damage /= 2;
                }
            }

            System.out.printf("%s - %d health, %.2f damage%n", inputArr[i], health, damage);
        }
    }
}
