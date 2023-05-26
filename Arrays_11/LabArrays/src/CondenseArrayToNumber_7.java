import java.util.Scanner;

public class CondenseArrayToNumber_7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();

        String[] strArr = userInput.split(" ");

        int[] numArr = new int[strArr.length];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        int[] condensedArr = new int[numArr.length - 1];
        while (numArr.length != 1) {

            for (int i = 0; i < numArr.length - 1; i++) {
                condensedArr[i] = numArr[i] + numArr[i + 1];
            }

            numArr = condensedArr;
            condensedArr = new int[numArr.length - 1];
        }

        if (numArr[0] == 1) {
            System.out.println("1 is already condensed to number");
        } else {
            System.out.println(numArr[0]);
        }
    }
}
