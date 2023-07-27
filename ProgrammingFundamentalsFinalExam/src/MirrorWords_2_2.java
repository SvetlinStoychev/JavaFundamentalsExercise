import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_2_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String text = reader.nextLine();
        String regex = "([@#])(?<wordOne>[A-Za-z]{3,})\\1\\1(?<wordTwo>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (!matcher.find()) {
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        } else {
            matcher.reset();
            int pairCnt = 0;
            ArrayList<String> mirrorWordsList = new ArrayList<>();

            while (matcher.find()) {
                pairCnt++;
                String firstWord = matcher.group("wordOne");
                String secondWord = matcher.group("wordTwo");
                String secondWordReverse = new StringBuilder(secondWord).reverse().toString();

                if (firstWord.equals(secondWordReverse)) {
                    mirrorWordsList.add(firstWord + " <=> " + secondWord);
                }
            }

            System.out.printf("%d word pairs found!%n", pairCnt);

            if (mirrorWordsList.size() > 0) {
                System.out.println("The mirror words are: ");
                System.out.println(String.join(", ", mirrorWordsList));
            } else {
                System.out.println("No mirror words!");
            }
        }
    }
}
