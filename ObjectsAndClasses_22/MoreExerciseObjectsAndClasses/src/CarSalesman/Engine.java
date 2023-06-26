package CarSalesman;

public class Engine {
    private String model;
    private String power;
    private String displacement = "n/a";
    private String efficiency = "n/a";
    public Engine(String[] data) {
        this.model = data[0];
        this.power = data[1];

        if (data.length == 3) {
            if (data[2].chars().allMatch(Character::isDigit)) {
                this.displacement = data[2];
            } else {
                this.efficiency = data[2];
            }
        } else if (data.length == 4) {
            this.displacement = data[2];
            this.efficiency = data[3];
        }
    }

    public String getModel() {
        return this.model;
    }

    public String getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }
}
