import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String inputText = reader.nextLine();
        String regex = "@([A-Za-z]{3,})@@([A-Za-z]{3,})@|#([A-Za-z]{3,})##([A-Za-z]{3,})#";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);

        int pairsCnt = 0;
        ArrayList<String> pairsWordsList = new ArrayList<>();

        while (matcher.find()) {
            pairsCnt++;
            String currentPairWords = matcher.group();
            String currentPairRegex = "([A-Za-z]{3,})|([A-Za-z]{3,})";
            Pattern currentPairPattern = Pattern.compile(currentPairRegex);
            Matcher currentPairMatcher = currentPairPattern.matcher(currentPairWords);

            String firstWord = "";
            String secondWord = "";
            int cnt = 0;

            while (currentPairMatcher.find()) {
                if (cnt == 0) {
                    firstWord = currentPairMatcher.group();
                    cnt++;
                } else {
                    secondWord = currentPairMatcher.group();
                }
            }

            StringBuilder sb = new StringBuilder(secondWord);
            sb.reverse();

            if (firstWord.equals(sb.toString())) {
                String result = firstWord.concat(" <=> ").concat(secondWord);
                pairsWordsList.add(result);
            }
        }


        if (pairsCnt > 0) {
            System.out.printf("%d word pairs found!%n", pairsCnt);
        } else {
            System.out.println("No word pairs found!");
        }

        if (pairsWordsList.size() > 0) {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", pairsWordsList));
        } else {
            System.out.println("No mirror words!");
        }
    }
}
