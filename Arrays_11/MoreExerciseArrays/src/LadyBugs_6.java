import java.util.Scanner;

public class LadyBugs_6 {
    private static int[] field = new int[0];
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int  fieldSize = Integer.parseInt(reader.nextLine());
        String  initialIndexes = reader.nextLine();
        field = createField(fieldSize, initialIndexes);

        String command = reader.nextLine();
        while (!command.equals("end")) {

            executeCommand(command);

            command = reader.nextLine();
        }

        printResultField();
    }

    private static void printResultField() {

        for (int i = 0; i < field.length; i++) {

            System.out.printf("%d ", field[i]);
        }
    }

    private static void executeCommand(String command) {
        String[] commandsArr = command.split(" ");
        int bugPosition = Integer.parseInt(commandsArr[0]);
        String bugDirection = commandsArr[1];
        int bugLengthFly = Integer.parseInt(commandsArr[2]);

        if (bugPosition >= 0 && bugPosition < field.length) {

            if (field[bugPosition] == 1) {
                field[bugPosition] = 0;

                if (bugDirection.equals("right")) {
                    int newPosition = bugPosition + bugLengthFly;

                    while (newPosition >= 0 && newPosition < field.length) {

                        if (field[newPosition] == 0) {
                            field[newPosition] = 1;
                            break;
                        } else {
                            newPosition += bugLengthFly;
                        }
                    }
                } else if (bugDirection.equals("left")) {
                    int newPosition = bugPosition - bugLengthFly;

                    while (newPosition >= 0 && newPosition < field.length) {

                        if (field[newPosition] == 0) {
                            field[newPosition] = 1;
                            break;
                        } else {
                            newPosition -= bugLengthFly;
                        }
                    }
                }
            }
        }
    }

    private static int[] createField(int fieldSize, String initialIndexes) {
        int[] fieldResult = new int[fieldSize];
        String[] initialIndexesArr = initialIndexes.split(" ");

        for (int i = 0; i < initialIndexesArr.length; i++) {
            int currentPosition = Integer.parseInt(initialIndexesArr[i]);

            if (currentPosition >= 0 && currentPosition < fieldResult.length) {
                fieldResult[currentPosition] = 1;
            }
        }

        return fieldResult;
    }
}
