import java.util.Scanner;

public class EnglishNameOfTheLastDigit_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        System.out.println(lastDigitName(n));
    }
    public static String lastDigitName(int n) {
        int lastDigit = n % 10;

        String digitName = "";
        switch (lastDigit) {
            case 0:
                digitName = "zero";
                break;
            case 1:
               digitName = "one";
               break;
            case 2:
                digitName = "two";
                break;
            case 3:
                digitName = "three";
                break;
            case 4:
                digitName = "four";
                break;
            case 5:
                digitName = "five";
                break;
            case 6:
                digitName = "six";
                break;
            case 7:
                digitName = "seven";
                break;
            case 8:
                digitName = "eight";
                break;
            case 9:
                digitName = "nine";
                break;
            default:
                digitName = "ERROR!";
        }

        return digitName;
    }
}
