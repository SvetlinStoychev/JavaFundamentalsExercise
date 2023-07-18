import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();
        String regex = "=([A-Z][A-Za-z]{2,})=|\\/([A-Z][A-Za-z]{2,})\\/";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        ArrayList<String> destinationsList = new ArrayList<>();
        int travelPoints = 0;

        while (matcher.find()) {
            String currentStop = matcher.group();
            if (currentStop.contains("=")) {
                currentStop = currentStop.replaceAll("\\=", "");
            } else if (currentStop.contains("/")) {
                currentStop = currentStop.replaceAll("\\/", "");
            }
            destinationsList.add(currentStop);
            travelPoints += currentStop.length();
        }

        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destinationsList));
        System.out.println("Travel Points: " + travelPoints);
    }
}
