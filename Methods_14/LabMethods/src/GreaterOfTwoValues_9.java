import java.util.Scanner;

public class GreaterOfTwoValues_9 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String inputType = reader.nextLine();

        switch (inputType) {
            case "int":
                int numOne = Integer.parseInt(reader.nextLine());
                int numTwo = Integer.parseInt(reader.nextLine());
                int resultInt = getMax(numOne, numTwo);
                System.out.println(resultInt);
                break;
            case "char":
                String firstStr = reader.nextLine();
                String secondStr = reader.nextLine();
                char first = firstStr.charAt(0);
                char second = secondStr.charAt(0);
                char resultChar = getMax(first, second);
                System.out.println(resultChar);
                break;
            case "string":
                String firstTxt = reader.nextLine();
                String secondText = reader.nextLine();
                String resultString = getMax(firstTxt, secondText);
                System.out.println(resultString);
                break;
            default:
                System.out.println("W.T.F is this command?");
        }
    }

    public static String getMax(String first, String second) {
        if (first.compareTo(second) > 0) {
            return first;
        }
        return second;
    }
    public static char getMax(char first, char second) {
        if (first > second) {
            return first;
        }
        return second;
    }
    public static int getMax(int first, int second) {
        if (first > second) {
            return first;
        }
        return second;
    }
}
