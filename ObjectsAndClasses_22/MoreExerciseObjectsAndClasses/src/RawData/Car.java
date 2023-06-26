package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires = new Tire[4];
    public Car(String carData) {
        String[] carDataArr = carData.split(" ");
        String model = carDataArr[0];
        int engineSpeed = Integer.parseInt(carDataArr[1]);
        int enginePower = Integer.parseInt(carDataArr[2]);
        int cargoWeight = Integer.parseInt(carDataArr[3]);
        String cargoType = carDataArr[4];
        double tire1Pressure = Double.parseDouble(carDataArr[5]);
        int tire1Age = Integer.parseInt(carDataArr[6]);
        double tire2Pressure = Double.parseDouble(carDataArr[7]);
        int tire2Age = Integer.parseInt(carDataArr[8]);
        double tire3Pressure = Double.parseDouble(carDataArr[9]);
        int tire3Age = Integer.parseInt(carDataArr[10]);
        double tire4Pressure = Double.parseDouble(carDataArr[11]);
        int tire4Age = Integer.parseInt(carDataArr[12]);

        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires[0] = new Tire(tire1Pressure, tire1Age);
        this.tires[1] = new Tire(tire2Pressure, tire2Age);
        this.tires[2] = new Tire(tire3Pressure, tire3Age);
        this.tires[3] = new Tire(tire4Pressure, tire4Age);
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Tire[] getTires() {
        return this.tires;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }
}
