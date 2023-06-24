import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue_5 {
    public static class  Vehicle {
        private String typeOfVehicle;
        private String model;
        private String color;
        private int horsePower;

        public Vehicle(String type, String model, String color, int horsePower) {
            this.typeOfVehicle = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }
        public String getTypeOfVehicle() {
            return this.typeOfVehicle;
        }
        public String getModel() {
            return this.model;
        }
        public String getColor() {
            return this.color;
        }
        public int getHorsePower() {
            return this.horsePower;
        }
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();

        List<Vehicle> catalogue = new ArrayList<>();

        while (!command.equals("End")) {
            String[] commandArr = command.split(" ");
            String typeOfVehicle = commandArr[0];
            String model = commandArr[1];
            String color = commandArr[2];
            int horsePower = Integer.parseInt(commandArr[3]);

            Vehicle currentVehicle = new Vehicle(typeOfVehicle, model, color, horsePower);
            catalogue.add(currentVehicle);

            command = reader.nextLine();
        }

        command = reader.nextLine();

        while (!command.equals("Close the Catalogue")) {
            for (Vehicle vehicle : catalogue) {
                if (vehicle.getModel().equals(command)) {
                    if (vehicle.getTypeOfVehicle().equals("car")) {
                        System.out.println("Type: Car");
                    } else {
                        System.out.println("Type: Truck");
                    }

                    System.out.println("Model: " + vehicle.getModel());
                    System.out.println("Color: " + vehicle.getColor());
                    System.out.println("Horsepower: " + vehicle.getHorsePower());
                }
            }
            command = reader.nextLine();
        }

        double[] carData = calculateHorsePowerSum(catalogue, "car");
        double sumCarHorsePower = carData[0];
        double cntCar = carData[1];
        double[] truckData = calculateHorsePowerSum(catalogue, "truck");
        double sumTruckHorsePower = truckData[0];
        double cntTruck = truckData[1];

        double averageHorsePowerCar = calculateAverageHorsePower(sumCarHorsePower, cntCar);
        double averageHorsePowerTruck = calculateAverageHorsePower(sumTruckHorsePower, cntTruck);

        if (cntCar == 0) {
            System.out.println("Cars have average horsepower of: 0.00.");
        } else {
            System.out.printf("Cars have average horsepower of: %.2f.%n", averageHorsePowerCar);
        }

        if (cntTruck == 0) {
            System.out.println("Trucks have average horsepower of: 0.00.");
        } else {
            System.out.printf("Trucks have average horsepower of: %.2f.%n", averageHorsePowerTruck);
        }


    }

    private static double calculateAverageHorsePower(double sumHorsePower, double cnt) {
        double result = sumHorsePower / cnt;
        return result;
    }

    private static double[] calculateHorsePowerSum(List<Vehicle> catalogue, String type) {
        double sum = 0.0;
        double cnt = 0;
        for (Vehicle vehicle : catalogue) {
            if (vehicle.getTypeOfVehicle().equals(type)) {
                sum += vehicle.getHorsePower();
                cnt++;
            }
        }
        double[] result = {sum, cnt};
        return result;
    }
}
