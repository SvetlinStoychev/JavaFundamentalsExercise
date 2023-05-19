import java.util.Scanner;

public class LowerOrUpper_8 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        char userInput = reader.nextLine().charAt(0);

        if (Character.isLowerCase(userInput)) {
            System.out.println("lower-case");
        } else if (Character.isUpperCase(userInput)) {
            System.out.println("upper-case");
        }
    }
}
