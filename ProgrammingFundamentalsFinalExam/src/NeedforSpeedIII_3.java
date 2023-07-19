import java.util.LinkedHashMap;
import java.util.Scanner;

public class NeedforSpeedIII_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        LinkedHashMap<String, int[]> carMileageFuelMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            // "{car}|{mileage}|{fuel}
            String[] newCarArr = reader.nextLine().split("\\|");
            String car = newCarArr[0];
            int[] mileageFuelArr = new int[2];
            mileageFuelArr[0] = Integer.parseInt(newCarArr[1]);
            mileageFuelArr[1] = Integer.parseInt(newCarArr[2]);
            carMileageFuelMap.put(car, mileageFuelArr);
        }

        String command = reader.nextLine();

        while (!command.equals("Stop")) {
            String[] commandArr = command.split(" : ");
            String currentCommand = commandArr[0];
            String car = commandArr[1];

            switch (currentCommand) {
                case "Drive": {
                    // Drive : {car} : {distance} : {fuel}
                    int distance = Integer.parseInt(commandArr[2]);
                    int fuel = Integer.parseInt(commandArr[3]);
                    int[] currentMileageFuelArr = carMileageFuelMap.get(car);
                    int currentMileage = currentMileageFuelArr[0];
                    int currentFuel = currentMileageFuelArr[1];

                    if (currentFuel >= fuel) {
                        currentMileage += distance;
                        currentFuel -= fuel;
                        System.out.printf("%s driven for %s kilometers. %s liters of fuel consumed.%n", car, distance, fuel);

                        if (currentMileage >= 100000) {
                            carMileageFuelMap.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        } else {
                            currentMileageFuelArr[0] = currentMileage;
                            currentMileageFuelArr[1] = currentFuel;
                            carMileageFuelMap.put(car, currentMileageFuelArr);
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                }
                    break;
                case "Refuel": {
                    // Refuel : {car} : {fuel}
                    int fuel = Integer.parseInt(commandArr[2]);
                    int[] currentMileageFuelArr = carMileageFuelMap.get(car);
                    int currentFuel = currentMileageFuelArr[1];

                    if (currentFuel + fuel <= 75) {
                        currentMileageFuelArr[1] = currentFuel + fuel;
                        carMileageFuelMap.put(car, currentMileageFuelArr);
                        System.out.printf("%s refueled with %d liters%n", car, fuel);
                    } else {
                        fuel = 75 - currentFuel;
                        currentMileageFuelArr[1] = 75;
                        carMileageFuelMap.put(car, currentMileageFuelArr);
                        System.out.printf("%s refueled with %d liters%n", car, fuel);
                    }
                }
                    break;
                case "Revert": {
                    // Revert : {car} : {kilometers}
                    int kilometers = Integer.parseInt(commandArr[2]);
                    int[] currentMileageFuelArr = carMileageFuelMap.get(car);
                    int currentMileage = currentMileageFuelArr[0];
                    currentMileage -= kilometers;

                    if (currentMileage < 10000) {
                        currentMileage = 10000;
                    }

                    currentMileageFuelArr[0] = currentMileage;
                    carMileageFuelMap.put(car, currentMileageFuelArr);
                    System.out.printf("%s mileage decreased by %d kilometers", car, kilometers);
                }
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);

            }
            command = reader.nextLine();
        }

        
    }
}
