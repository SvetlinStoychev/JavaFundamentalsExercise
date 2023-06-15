import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery_2_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Integer> numberOfHeartsForEachHouse = Arrays.stream(reader.nextLine().split("\\@"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = reader.nextLine();
        int jumpIndex = 0;

        while (!command.equals("Love!")) {
            String[] commandArr = command.split(" ");
            int jumpLength = Integer.parseInt(commandArr[1]);
            jumpIndex += jumpLength;

            if (jumpIndex > numberOfHeartsForEachHouse.size() - 1) {
                jumpIndex = 0;
            }

            if (numberOfHeartsForEachHouse.get(jumpIndex) == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", jumpIndex);
            } else {
                int neededHearts = numberOfHeartsForEachHouse.get(jumpIndex);
                neededHearts -= 2;
                numberOfHeartsForEachHouse.set(jumpIndex, neededHearts);
                if (neededHearts == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", jumpIndex);
                }
            }

            command = reader.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", jumpIndex);

        boolean  eachHouseHasValentineDay = true;
        int houseCount = 0;

        for (int i = 0; i < numberOfHeartsForEachHouse.size(); i++) {
            if (numberOfHeartsForEachHouse.get(i) != 0) {
                eachHouseHasValentineDay = false;
                houseCount++;
            }
        }

        if (eachHouseHasValentineDay) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", houseCount);
        }
    }
}
