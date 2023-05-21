import java.util.Scanner;

public class DataTypeFinder_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();

        while (!userInput.equals("END")) {

            if (userInput.matches("-?\\d+")) {
                // checking for Integer
                System.out.printf("%s is integer type%n", userInput);
            } else if (userInput.matches("[+-]?\\d*\\.\\d+")) {
               // checking for floating point numbers
                System.out.printf("%s is floating point type%n", userInput);
            } else if (userInput.length() == 1) {
                System.out.printf("%s is character type%n", userInput);
            } else if (userInput.equalsIgnoreCase("true")  || userInput.equalsIgnoreCase("false")) {
                System.out.printf("%s is boolean type%n", userInput);
            } else {
                System.out.printf("%s is string type%n", userInput);
            }

            userInput = reader.nextLine();
        }
    }
}
