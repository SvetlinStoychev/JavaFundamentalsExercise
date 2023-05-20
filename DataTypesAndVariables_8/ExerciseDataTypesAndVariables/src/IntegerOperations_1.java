import java.util.Scanner;

public class IntegerOperations_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int firstNum = Integer.parseInt(reader.nextLine());
        int secondNum = Integer.parseInt(reader.nextLine());
        int thirdNum = Integer.parseInt(reader.nextLine());
        int fourthNum = Integer.parseInt(reader.nextLine());

        int result = ((firstNum + secondNum) / thirdNum) * fourthNum;

        System.out.println(result);
    }
}
