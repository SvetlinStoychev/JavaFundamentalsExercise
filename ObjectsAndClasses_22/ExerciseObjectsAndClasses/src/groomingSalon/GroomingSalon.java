package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data = new ArrayList<>();

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }
    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }
    public int getCount() {
        return this.data.size();
    }
    public String getStatistics() {
        StringBuilder str = new StringBuilder();
        str.append("The grooming salon has the following clients:");
        str.append("\n");

        for (Pet pet : data) {
            str.append(pet.getName() + " " + pet.getOwner());
            str.append("\n");
        }
        return str.toString();
    }
}
