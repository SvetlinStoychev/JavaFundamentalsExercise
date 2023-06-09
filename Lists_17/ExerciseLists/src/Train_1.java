import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_1 {
    private static List<Integer> listOfWagons = new ArrayList<>();
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        listOfWagons = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacityOfWagon = Integer.parseInt(reader.nextLine());
        String inputCommand = reader.nextLine();

        while (!inputCommand.equals("end")) {
            String[] inputCommandArr = inputCommand.split(" ");
            String currentCommand = inputCommandArr[0];

            if (currentCommand.equals("Add")) {
                int passengersInWagon = Integer.parseInt(inputCommandArr[1]);
                executeAddWagon(passengersInWagon);
            } else {
                int passengerToAdd = Integer.parseInt(inputCommandArr[0]);
                executeAddPassengers(passengerToAdd, maxCapacityOfWagon);
            }

            inputCommand = reader.nextLine();
        }

        printTrainFinalState();
    }

    private static void printTrainFinalState() {
        System.out.println(listOfWagons.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void executeAddPassengers(int passengerToAdd, int wagonCapacity) {
        for (int i = 0; i < listOfWagons.size(); i++) {
            int totalNumOfPassengers = listOfWagons.get(i) + passengerToAdd;

            if (totalNumOfPassengers <= wagonCapacity) {
                listOfWagons.set(i, totalNumOfPassengers);
                break;
            }
        }
    }

    private static void executeAddWagon(int passengersInWagon) {
        listOfWagons.add(passengersInWagon);
    }
}
