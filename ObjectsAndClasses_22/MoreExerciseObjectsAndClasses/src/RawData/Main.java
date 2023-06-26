package RawData;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        Car[] cars = new Car[n];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(reader.nextLine());
        }

        String command = reader.nextLine();

        if (command.equals("fragile")) {

            for (Car car : cars) {

                if (car.getCargo().getCargoType().equals(command)) {
                    Tire[] tires = car.getTires();

                    if (tires[0].getTirePressure() < 1.0 || tires[1].getTirePressure() < 1.0 ||
                        tires[2].getTirePressure() < 1.0 || tires[3].getTirePressure() < 1.0) {

                        System.out.println(car.getModel());
                    }
                }
            }
        } else if(command.equals("flamable")) {

            for (Car car : cars) {

                if (car.getCargo().getCargoType().equals(command) &&
                    car.getEngine().getEnginePower() > 250) {

                    System.out.println(car.getModel());
                }
            }
        } else {
            System.out.println("W.T.F is " + command);
        }
    }
}
