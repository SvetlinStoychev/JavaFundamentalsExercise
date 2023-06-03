import java.util.Scanner;

public class SmallestOfThreeNumbers_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int numOne = Integer.parseInt(reader.nextLine());
        int numTwo = Integer.parseInt(reader.nextLine());
        int numThree = Integer.parseInt(reader.nextLine());

        printSmallestOfThree(numOne, numTwo, numThree);
    }

    public static void printSmallestOfThree(int numOne, int numTwo, int numThree) {
        int result = 0;
        if (numOne <= numTwo && numOne <= numThree) {
            result = numOne;
        } else if (numTwo <= numOne && numTwo <= numThree) {
            result = numTwo;
        } else if (numThree <= numOne && numThree <= numTwo) {
            result = numThree;
        } else {
            System.out.println("W.T.F?");
        }
        System.out.println(result);
    }
}
