import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        int attackedPlanetsCnt = 0;
        int destroyedPlanetsCnt = 0;

        ArrayList<String> attackedPlanetsList = new ArrayList<>();
        ArrayList<String> destroyedPlanetsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = reader.nextLine();
            int key = 0;

            for (int j = 0; j < input.length(); j++) {

                if (input.charAt(j) == 's' || input.charAt(j) == 't' || input.charAt(j) == 'a' || input.charAt(j) == 'r'
                        || input.charAt(j) == 'S' || input.charAt(j) == 'T' || input.charAt(j) == 'A' || input.charAt(j) == 'R') {
                    key++;
                }
            }

            StringBuilder decryptInput = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                char currentSymbol = (char)(input.charAt(j) - key);
                decryptInput.append(currentSymbol);
            }

            String regex = "@(?<name>[A-Za-z]+)[^@\\-!:]*?:(?<population>\\d+)[^@\\-!:]*?!(?<attackType>[A]*[D]*)![^@\\-!:]*?->(?<soldierCount>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptInput);

            if (matcher.find()) {
                String name = matcher.group("name");
                String attackType = matcher.group("attackType");

                if (attackType.equals("A")) {
                    attackedPlanetsCnt++;
                    attackedPlanetsList.add(name);
                } else if (attackType.equals("D")) {
                    destroyedPlanetsCnt++;
                    destroyedPlanetsList.add(name);
                }
            }

            System.out.println();
        }

        System.out.printf("Attacked planets: %d%n", attackedPlanetsCnt);
        Collections.sort(attackedPlanetsList);
        for (int i = 0; i < attackedPlanetsList.size(); i++) {
            System.out.printf("-> %s%n", attackedPlanetsList.get(i));
        }

        System.out.printf("Destroyed planets: %d%n", destroyedPlanetsCnt);
        Collections.sort(destroyedPlanetsList);
        for (int i = 0; i < destroyedPlanetsList.size(); i++) {
            System.out.printf("-> %s%n", destroyedPlanetsList.get(i));
        }
    }
}
