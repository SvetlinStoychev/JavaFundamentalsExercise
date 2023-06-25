package groomingSalon;

public class Pet {
    private String name;
    private int age;
    private String owner;

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " - (" + this.owner + ")";
    }

    public String getName() {
        return this.name;
    }

    public String getOwner() {
        return owner;
    }
}
