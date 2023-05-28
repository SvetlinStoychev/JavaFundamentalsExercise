import java.util.Scanner;

public class ArrayModifier_9 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();
        String[] inputArr = userInput.split(" ");
        int[] numbers = new int[inputArr.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputArr[i]);
        }

        String command = reader.nextLine();

        while (!command.equals("end")) {

            String[] commandArr = command.split(" ");

            if (command.contains("swap")) {

                int firstIndex = Integer.parseInt(commandArr[1]);
                int secondIndex = Integer.parseInt(commandArr[2]);

                int temp = numbers[firstIndex];
                numbers[firstIndex] = numbers[secondIndex];
                numbers[secondIndex] = temp;

            } else if (command.contains("multiply")) {

                int firstIndex = Integer.parseInt(commandArr[1]);
                int secondIndex = Integer.parseInt(commandArr[2]);

                int product = numbers[firstIndex] * numbers[secondIndex];
                numbers[firstIndex] = product;

            } else if (command.contains("decrease")) {

                for (int i = 0; i < numbers.length; i++) {
                    numbers[i]--;
                }

            } else {
                System.out.println("W.T.F is this command?");
            }

            command = reader.nextLine();
        }

        for (int i = 0; i < numbers.length - 1; i++) {

            System.out.printf("%d, ", numbers[i]);
        }

        System.out.printf("%d%n", numbers[numbers.length - 1]);
    }
}
