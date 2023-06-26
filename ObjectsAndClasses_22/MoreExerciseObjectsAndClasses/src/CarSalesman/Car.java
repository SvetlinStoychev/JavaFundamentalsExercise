package CarSalesman;

public class Car {
    private String  model;
    private Engine engine;
    private String weight = "n/a";
    private String color = "n/a";

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, String weightOrColor) {
        this.model = model;
        this.engine = engine;

        if (weightOrColor.chars().allMatch(Character::isDigit)) {
            this.weight = weightOrColor;
        } else {
            this.color = weightOrColor;
        }
    }

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
    public void printCarData() {
        System.out.printf("%s:%n", this.model);
        System.out.printf("  %s:%n", this.engine.getModel());
        System.out.printf("    Power: %s%n", this.engine.getPower());
        System.out.printf("    Displacement: %s%n", this.engine.getDisplacement());
        System.out.printf("    Efficiency: %s%n", this.engine.getEfficiency());
        System.out.printf("  Weight: %s%n", this.weight);
        System.out.printf("  Color: %s%n", this.color);
    }
}
