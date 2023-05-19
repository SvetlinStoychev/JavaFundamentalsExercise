import java.util.Scanner;

public class Passed {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        double grade = Double.parseDouble(reader.nextLine());

        if(grade >= 3) {
            System.out.println("Passed!");
        }
    }
}
