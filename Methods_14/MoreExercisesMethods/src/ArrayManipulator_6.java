import java.util.Scanner;

public class ArrayManipulator_6 {
    private static int[] arr = new int[0];
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String inputDataArr = reader.nextLine();
        createInputArray(inputDataArr);
        String userCommand = reader.nextLine();

        while (!userCommand.equals("end")) {
            String[] commandArr = userCommand.split(" ");

            if (commandArr[0].equals("exchange")) {
                int index = Integer.parseInt(commandArr[1]);
                executeExchange(index);
            } else if (commandArr[0].equals("max")) {
                if (commandArr[1].equals("even")) {
                    executeMaxEven();
                } else if (commandArr[1].equals("odd")) {
                    executeMaxOdd();
                }
            } else if (commandArr[0].equals("min")) {
                if (commandArr[1].equals("even")){
                    executeMinEven();
                } else if (commandArr[1].equals("odd")) {
                    executeMinOdd();
                }
            } else if (commandArr[0].equals("first")) {
                int countFirst = Integer.parseInt(commandArr[1]);
                if (commandArr[2].equals("even")) {
                    executeFirstEven(countFirst);
                } else if (commandArr[2].equals("odd")) {
                    executeFirstOdd(countFirst);
                }
            } else if (commandArr[0].equals("last")) {
                int countLast = Integer.parseInt(commandArr[1]);
                if (commandArr[2].equals("even")) {
                    executeLastEven(countLast);
                } else if (commandArr[2].equals("odd")) {
                    executeLastOdd(countLast);
                }
            }

            userCommand = reader.nextLine();
        }
        
        printFinalArrayState();
    }

    private static void printFinalArrayState() {
    }

    private static void executeLastOdd(int countLast) {
    }

    private static void executeLastEven(int countLast) {
    }

    private static void executeFirstOdd(int count) {
    }

    private static void executeFirstEven(int count) {
    }

    private static void executeMinOdd() {
    }

    private static void executeMinEven() {
    }

    private static void executeMaxOdd() {
    }

    private static void executeMaxEven() {
    }

    private static void executeExchange(int index) {
    }

    private static void createInputArray(String inputDataArr) {
        String[] strArr = inputDataArr.split(" ");
        arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
    }
}
