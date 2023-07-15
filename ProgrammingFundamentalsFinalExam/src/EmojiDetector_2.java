import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();

        String regexDigit = "\\d";
        Pattern pattern = Pattern.compile(regexDigit);
        Matcher matcher = pattern.matcher(input);

        long coolThreshold = 1;

        while (matcher.find()) {
            int currentDigit = Integer.parseInt(matcher.group());
            coolThreshold *= currentDigit;
        }

        System.out.println("Cool threshold: " + coolThreshold);

        String regexEmoji = "(\\*{2})[A-Z][a-z]{2,}(\\*{2})|(\\:{2})[A-Z][a-z]{2,}(\\:{2})";
        pattern = Pattern.compile(regexEmoji);
        matcher = pattern.matcher(input);

        int countValidEmojis = 0;
        ArrayList<String> coolEmojiList = new ArrayList<>();

        while (matcher.find()) {
            countValidEmojis++;
            String currentEmoji = matcher.group();
            String regexLetters = "[A-Za-z]";
            Pattern patternTwo = Pattern.compile(regexLetters);
            Matcher matcherTwo = patternTwo.matcher(currentEmoji);

            long currentEmojiCoolness = 0;
            while (matcherTwo.find()) {
                char currentLetter = matcherTwo.group().charAt(0);
                currentEmojiCoolness += currentLetter;
            }

            if (currentEmojiCoolness > coolThreshold) {
                coolEmojiList.add(currentEmoji);
            }
        }

        System.out.printf("%d emojis found in the text. The cool ones are:%n", countValidEmojis);

        for (String emoji : coolEmojiList) {
            System.out.println(emoji + " ");
        }
    }
}
