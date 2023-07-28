import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_2_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String text = reader.nextLine();
        String digitRegex = "\\d";
        Pattern pattern = Pattern.compile(digitRegex);
        Matcher matcher = pattern.matcher(text);

        long coolThreshold = 1;

        while (matcher.find()) {
            int temp = Integer.parseInt(matcher.group());
            coolThreshold *= temp;
        }

        System.out.println("Cool threshold: " + coolThreshold);

        String emojiRegex = "(\\*{2})[A-Z][a-z]{2,}(\\*{2})|(\\:{2})[A-Z][a-z]{2,}(\\:{2})";
        pattern = Pattern.compile(emojiRegex);
        matcher = pattern.matcher(text);

        int emojiCnt = 0;
        ArrayList<String> emojiList = new ArrayList<>();

        while (matcher.find()) {
            emojiCnt++;
            long coolness = 0;
            String currentEmoji = matcher.group();
            String letterRegex = "[A-Za-z]";
            Pattern patternTwo = Pattern.compile(letterRegex);
            Matcher matcherTwo = patternTwo.matcher(currentEmoji);

            while (matcherTwo.find()) {
                char currentLetter = matcherTwo.group().charAt(0);
                coolness += currentLetter;
            }

            if (coolness > coolThreshold) {
                emojiList.add(currentEmoji);
            }
        }

        System.out.printf("%d emojis found in the text. The cool ones are:%n", emojiCnt);

        for (String emoji : emojiList) {
            System.out.println(emoji + " ");
        }
    }
}
