import java.util.Scanner;

public class Elevator_3 {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(reader.nextLine());
        int capacity = Integer.parseInt(reader.nextLine());

        int courses = 0;
        if (numberOfPeople % capacity == 0) {
            courses = numberOfPeople / capacity;
        } else {
            courses = (numberOfPeople / capacity) + 1;
        }

        System.out.println(courses);
    }
}
