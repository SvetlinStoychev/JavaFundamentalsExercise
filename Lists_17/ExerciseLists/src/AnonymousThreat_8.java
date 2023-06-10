import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat_8 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<String> inputList = Arrays.stream(reader.nextLine().split(" ")).collect(Collectors.toList());
        String command = reader.nextLine();

        while (!command.equals("3:1")) {
            String[] commandsParts = command.split(" ");
            String firstCommand = commandsParts[0];
            int secondCommand = Integer.parseInt(commandsParts[1]);
            int thirdCommand = Integer.parseInt(commandsParts[2]);

            if (firstCommand.equals("merge")) {
                if (secondCommand <= 0) {
                    secondCommand = 0;
                } else if (secondCommand > inputList.size() - 1) {
                    secondCommand = inputList.size() - 1;
                }

                if (thirdCommand > inputList.size() - 1) {
                    thirdCommand = inputList.size() - 1;
                } else if (thirdCommand < 0) {
                    thirdCommand = 0;
                }

                String result = "";

                for (int i = secondCommand; i <= thirdCommand ; i++) {
                    result += inputList.get(i);
                }

                for (int i = secondCommand; i <= thirdCommand ; i++) {
                    inputList.remove(secondCommand);
                }

                inputList.add(secondCommand, result);
            } else if (firstCommand.equals("divide")) {
                String elementToDivide = inputList.get(secondCommand);
                inputList.remove(secondCommand);

                int currentPartitionSize = elementToDivide.length() / thirdCommand;
                int cnt = 0;

                if (elementToDivide.length() % thirdCommand == 0) {


                    for (int i = 0; i < thirdCommand; i++) {
                        String currentElement = "";

                        for (int j = cnt; j < currentPartitionSize + cnt; j++) {
                            currentElement += elementToDivide.charAt(j);
                        }
                        inputList.add(secondCommand, currentElement);
                        secondCommand++;
                        cnt += currentPartitionSize;
                    }
                } else {

                    for (int i = 0; i < thirdCommand; i++) {
                        String currentElement = "";

                        if (i == thirdCommand - 1) {
                            for (int j = cnt; j < elementToDivide.length(); j++) {
                                currentElement += elementToDivide.charAt(j);
                            }
                        } else {
                            for (int j = cnt; j < currentPartitionSize + cnt; j++) {
                                currentElement += elementToDivide.charAt(j);
                            }
                        }

                        if (!currentElement.equals("")) {
                            inputList.add(secondCommand, currentElement);
                            secondCommand++;
                        }

                        cnt += currentPartitionSize;
                    }
                }
            } else {
                System.out.println("W.T.F is " + firstCommand);
            }

            command = reader.nextLine();
        }

        System.out.println(inputList.toString().replaceAll("[\\[\\],]", ""));
    }
}
