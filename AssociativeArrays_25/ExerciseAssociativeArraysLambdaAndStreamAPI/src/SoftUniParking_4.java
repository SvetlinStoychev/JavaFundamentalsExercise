import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        LinkedHashMap<String, String> parkingMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] commandArr = reader.nextLine().split(" ");

            String command = commandArr[0];
            String username = commandArr[1];

            switch (command) {
                case "register":
                    if (parkingMap.containsKey(username)) {
                        String currentNumberPlate = parkingMap.get(username);
                        System.out.printf("ERROR: already registered with plate number %s%n", currentNumberPlate);
                    } else {
                        String licensePlateNumber = commandArr[2];
                        parkingMap.put(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    if (parkingMap.containsKey(username)) {
                        parkingMap.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    } else {
                        System.out.printf("ERROR: user %s not found%n", username);
                    }
                    break;
                default:
                    System.out.println("W.T.F is " + command);
            }
        }

        for (Map.Entry<String, String> entry : parkingMap.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
