import java.util.Scanner;

public class StudentInformation {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String name = reader.nextLine();
        int age = Integer.parseInt(reader.nextLine());
        double grade = Double.parseDouble(reader.nextLine());

        System.out.printf("Name: %s, Age: %d, Grade: %.2f", name, age, grade);
    }
}
