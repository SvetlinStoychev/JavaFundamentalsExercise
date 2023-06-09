import java.util.*;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_5 {
    private static List<Integer> inputList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        inputList = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String inputCommand = reader.nextLine();

        while (!inputCommand.equals("end")) {
            String[] inputArrCommand = inputCommand.split(" ");
            String currentCommand = inputArrCommand[0];

            switch (currentCommand) {
                case "Contains":
                    int num = Integer.parseInt(inputArrCommand[1]);
                    executeContains(num);
                    break;
                case "Print":
                    String nextCommand = inputArrCommand[1];
                    if (nextCommand.equals("even")) {
                        executePrintEven();
                    } else if (nextCommand.equals("odd")) {
                        executePrintOdd();
                    } else {
                        System.out.printf("W.T.F is %s%n", inputArrCommand[1]);
                    }
                    break;
                case "Get":
                    executeGetSum();
                    break;
                case "Filter":
                    String condition = inputArrCommand[1];
                    int numToFilter = Integer.parseInt(inputArrCommand[2]);
                    executeFilter(condition, numToFilter);
                    break;
                default:
                    System.out.printf("W.T.F is %s%n", inputArrCommand[0]);
                    break;
            }

            inputCommand = reader.nextLine();
        }
    }

    private static void executeFilter(String condition, int numToFilter) {
        if (condition.equals("<")) {
            for (int i = 0; i < inputList.size(); i++) {
                int currentNum = inputList.get(i);
                if (currentNum < numToFilter) {
                    System.out.printf("%d ", currentNum);
                }
            }
        } else if (condition.equals(">")) {
            for (int i = 0; i < inputList.size(); i++) {
                int currentNum = inputList.get(i);
                if (currentNum > numToFilter) {
                    System.out.printf("%d ", currentNum);
                }
            }
        } else if(condition.equals(">=")) {
            for (int i = 0; i < inputList.size(); i++) {
                int currentNum = inputList.get(i);
                if (currentNum >= numToFilter) {
                    System.out.printf("%d ", currentNum);
                }
            }
        } else if (condition.equals("<=")) {
            for (int i = 0; i < inputList.size(); i++) {
                int currentNum = inputList.get(i);
                if (currentNum <= numToFilter) {
                    System.out.printf("%d ", currentNum);
                }
            }
        } else {
            System.out.println("W.T.F is " + condition);
        }
        System.out.println();
    }

    private static void executeGetSum() {
        int sum = 0;
        for (int i = 0; i < inputList.size(); i++) {
            int currentNum = inputList.get(i);
            sum += currentNum;
        }
        System.out.println(sum);
    }

    private static void executePrintOdd() {
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i) % 2 != 0) {
                System.out.printf("%d ", inputList.get(i));
            }
        }
        System.out.println();
    }

    private static void executePrintEven() {
        for (int i = 0; i < inputList.size(); i++) {
            if (inputList.get(i) % 2 == 0) {
                System.out.printf("%d ", inputList.get(i));
            }
        }
        System.out.println();
    }

    private static void executeContains(int num) {
        if (inputList.contains(num)) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }
}
