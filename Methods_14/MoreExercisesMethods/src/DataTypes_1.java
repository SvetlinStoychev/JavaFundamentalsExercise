import java.util.Scanner;

public class DataTypes_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();

        switch (input) {
            case "int":
                int numInputInt = Integer.parseInt(reader.nextLine());
                int resultInt = manipulateData(numInputInt);
                System.out.println(resultInt);
                break;
            case "real":
                double numInputDouble = Double.parseDouble(reader.nextLine());
                double resultDouble = manipulateData(numInputDouble);
                System.out.printf("%.2f", resultDouble);
                break;
            case "string":
                String strInput = reader.nextLine();
                String resultStr = manipulateData(strInput);
                System.out.println(resultStr);
                break;
            default:
                System.out.println("W.T.F?");
        }
    }
    private static String manipulateData(String strInput) {
        String first = "$" + strInput;
        String result = first + "$";
        return result;
    }
    private static double manipulateData(double numInputDouble) {
        return numInputDouble * 1.5;
    }
    private static int manipulateData(int numInputInt) {
        return numInputInt * 2;
    }
}
