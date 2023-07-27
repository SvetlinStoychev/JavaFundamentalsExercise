import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIII_3_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        LinkedHashMap<String, Integer> mileageMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> fuelMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] carInfoArr = reader.nextLine().split("\\|");
            // "{car}|{mileage}|{fuel}"
            String car = carInfoArr[0];
            int mileage = Integer.parseInt(carInfoArr[1]);
            int fuel = Integer.parseInt(carInfoArr[2]);

            mileageMap.put(car, mileage);
            fuelMap.put(car, fuel);
        }

        String command = reader.nextLine();

        while (!command.equals("Stop")) {
            String[] commandsArr = command.split("\\ \\:\\ ");
            String currentCommand = commandsArr[0];
            String car = commandsArr[1];

            switch (currentCommand) {
                case "Drive": {
                    // Drive : {car} : {distance} : {fuel}":
                    //o	You need to drive the given distance, and you will need the given fuel to do that.
                    // If the car doesn't have enough fuel, print: "Not enough fuel to make that ride"
                    //o	If the car has the required fuel available in the tank, increase its mileage with
                    // the given distance, decrease its fuel with the given fuel, and print:
                    //"{car} driven for {distance} kilometers. {fuel} liters of fuel consumed."
                    //o	You like driving new cars only, so if a car's mileage reaches 100 000 km, remove it
                    // from the collection(s) and print: "Time to sell the {car}!"
                    int fuel = Integer.parseInt(commandsArr[3]);

                    if (fuel > fuelMap.get(car)) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int distance = Integer.parseInt(commandsArr[2]);
                        mileageMap.put(car, mileageMap.get(car) + distance);
                        fuelMap.put(car, fuelMap.get(car) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);

                        if (mileageMap.get(car) > 100000) {
                            mileageMap.remove(car);
                            fuelMap.remove(car);
                            System.out.printf("Time to sell the %s!%n", car);
                        }
                    }
                }
                    break;
                case "Refuel": {
                    // Refuel : {car} : {fuel}":
                    //o	Refill the tank of your car.
                    //o	Each tank can hold a maximum of 75 liters of fuel, so if the given amount of fuel is
                    // more than you can fit in the tank, take only what is required to fill it up.
                    //o	Print a message in the following format: "Refuel : {car} : {fuel}":
                    //o	Refill the tank of your car.
                    //o	Each tank can hold a maximum of 75 liters of fuel, so if the given amount of fuel is more than you can fit in the tank, take only what is required to fill it up.
                    //o	Print a message in the following format: "{car} refueled with {fuel} liters""
                    int fuel = Integer.parseInt(commandsArr[2]);

                    if (fuelMap.get(car) + fuel > 75) {
                        fuel = 75 - fuelMap.get(car);
                    }

                    fuelMap.put(car, fuelMap.get(car) + fuel);
                    System.out.printf("%s refueled with %d liters%n", car, fuel);
                }
                    break;
                case "Revert": {
                    // Revert : {car} : {kilometers}":
                    //o	Decrease the mileage of the given car with the given kilometers and print the kilometers
                    // you have decreased it with in the following format:
                    //"{car} mileage decreased by {amount reverted} kilometers"
                    //o	If the mileage becomes less than 10 000km after it is decreased, just set it to 10 000km
                    // and
                    //DO NOT print anything.
                    int kilometers = Integer.parseInt(commandsArr[2]);

                    if (mileageMap.get(car) - kilometers < 10000) {
                        mileageMap.put(car, 10000);
                    } else {
                        mileageMap.put(car, mileageMap.get(car) - kilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                }
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
            }

            command = reader.nextLine();
        }

        for (Map.Entry<String, Integer> entry : mileageMap.entrySet()) {
            String car = entry.getKey();
            int mileage = entry.getValue();
            int fuel = fuelMap.get(entry.getKey());

            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car, mileage, fuel);
        }
    }
}
