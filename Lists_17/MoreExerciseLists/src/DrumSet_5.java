import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        double  savings = Double.parseDouble(reader.nextLine());
        List<Integer> drumSet = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> drumSetCopy = new ArrayList<>();
        for (int i = 0; i < drumSet.size(); i++) {
            drumSetCopy.add(drumSet.get(i));
        }

        String command = reader.nextLine();

        while (!command.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(command);

            for (int i = 0; i < drumSetCopy.size(); i++) {
                int quality = drumSetCopy.get(i);
                quality -= hitPower;

                if (quality <= 0) {
                    double price = drumSet.get(i) * 3;

                    if (savings >= price) {
                        savings -= price;
                        drumSetCopy.set(i, drumSet.get(i));
                    } else {
                        drumSetCopy.remove(i);
                        drumSet.remove(i);
                        i--;
                    }
                } else {
                    drumSetCopy.set(i, quality);
                }
            }
            command = reader.nextLine();
        }

        System.out.println(drumSetCopy.toString().replaceAll("[\\[\\],]", ""));
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
