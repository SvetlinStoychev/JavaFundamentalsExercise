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
        if (count > arr.length - 1) {
            System.out.println("Invalid count");
        } else {
            int currentCnt = 0;
            System.out.print("[");

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] % 2 == 0) {

                    if (currentCnt != 0) {
                        System.out.print(", ");
                    }

                    System.out.printf("%d", arr[i]);
                    currentCnt++;
                }

                if (currentCnt == count) {
                    System.out.print("]");
                    break;
                } else if (i == arr.length - 1) {
                    System.out.print("]");
                }
            }
        }
    }

    private static void executeMinOdd() {
        int minOddNum = Integer.MAX_VALUE;
        int minOddNumIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                if (arr[i] <= minOddNum) {
                    minOddNum = arr[i];
                    minOddNumIndex = i;
                }
            }
        }

        if (minOddNumIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(minOddNumIndex);
        }
    }

    private static void executeMinEven() {
        int minEvenNum = Integer.MAX_VALUE;
        int minEvenNumIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] <= minEvenNum) {
                    minEvenNum = arr[i];
                    minEvenNumIndex = i;
                }
            }
        }

        if (minEvenNumIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(minEvenNumIndex);
        }
    }

    private static void executeMaxOdd() {
        int maxOddNum = Integer.MIN_VALUE;
        int maxOddNumIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                if (arr[i] >= maxOddNum) {
                    maxOddNum = arr[i];
                    maxOddNumIndex = i;
                }
            }
        }

        if (maxOddNumIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(maxOddNumIndex);
        }
    }

    private static void executeMaxEven() {
        int maxEvenNum = Integer.MIN_VALUE;
        int maxEvenNumIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] >= maxEvenNum) {
                    maxEvenNum = arr[i];
                    maxEvenNumIndex = i;
                }
            }
        }

        if (maxEvenNumIndex == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(maxEvenNumIndex);
        }
    }

    private static void executeExchange(int index) {
        if (index < 0 || index > arr.length - 1) {
            System.out.println("Invalid index");
        } else {
            int[] firstArr = new int[index + 1];
            int[] secondArr = new int[arr.length - (index + 1)];

            for (int i = 0; i < firstArr.length; i++) {
                firstArr[i] = arr[i];
            }

            for (int i = 0; i < secondArr.length; i++) {
                secondArr[i] = arr[i + index + 1];
            }

            for (int i = 0; i < secondArr.length; i++) {
                arr[i] = secondArr[i];
            }

            for (int i = 0; i < firstArr.length; i++) {
                arr[i + secondArr.length] = firstArr[i];
            }
        }
    }

    private static void createInputArray(String inputDataArr) {
        String[] strArr = inputDataArr.split(" ");
        arr = new int[strArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
    }
}
