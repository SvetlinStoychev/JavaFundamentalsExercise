package CarSalesman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        Engine[] enginesArr = new Engine[n];

        for (int i = 0; i < enginesArr.length; i++) {
            String[] engineDataArr = reader.nextLine().split(" ");
            Engine currentEngine = new Engine(engineDataArr);
            enginesArr[i] = currentEngine;
        }

        int m = Integer.parseInt(reader.nextLine());
        Car[] carsArr = new Car[m];

        for (int i = 0; i < carsArr.length; i++) {
            String[] inputData = reader.nextLine().split(" ");
            String model = inputData[0];
            String engineStr = inputData[1];

            for (int j = 0; j < enginesArr.length; j++) {

                if (enginesArr[j].getModel().equals(engineStr)) {

                    if (inputData.length == 3) {
                        Car currentCar = new Car(model, enginesArr[j], inputData[2] );
                        carsArr[i] = currentCar;
                    } else if (inputData.length == 2) {
                        Car currentCar = new Car(model, enginesArr[j]);
                        carsArr[i] = currentCar;
                    } else {
                        Car currentCar = new Car(model, enginesArr[j], inputData[2], inputData[3]);
                        carsArr[i] = currentCar;
                    }

                    break;
                }
            }
        }

        for (Car car : carsArr) {
            car.printCarData();
        }
    }
}
