import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_2_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String places = reader.nextLine();
        String regex = "([\\=\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(places);

        int travelPoints = 0;
        ArrayList<String> destinationsList = new ArrayList<>();

        while (matcher.find()) {
            String currentDestination = matcher.group("destination");
            destinationsList.add(currentDestination);
            travelPoints += currentDestination.length();
        }

        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destinationsList));
        System.out.println("Travel Points: " + travelPoints);
    }
}
