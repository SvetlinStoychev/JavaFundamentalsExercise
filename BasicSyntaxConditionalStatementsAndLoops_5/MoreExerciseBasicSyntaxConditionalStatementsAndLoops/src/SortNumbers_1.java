import java.util.Scanner;

public class SortNumbers_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int numOne = Integer.parseInt(reader.nextLine());
        int numTwo = Integer.parseInt(reader.nextLine());
        int numThree = Integer.parseInt(reader.nextLine());

        if (numOne >= numTwo && numOne >= numThree) {
            System.out.println(numOne);
            if (numTwo >= numThree) {
                System.out.println(numTwo);
                System.out.println(numThree);
            } else {
                System.out.println(numThree);
                System.out.println(numTwo);
            }
        } else if(numTwo >= numOne && numTwo >= numThree){
            System.out.println(numTwo);
            if (numOne >= numThree) {
                System.out.println(numOne);
                System.out.println(numThree);
            } else {
                System.out.println(numThree);
                System.out.println(numOne);
            }
        } else {
            System.out.println(numThree);
            if (numOne >= numTwo) {
                System.out.println(numOne);
                System.out.println(numTwo);
            } else {
                System.out.println(numTwo);
                System.out.println(numOne);
            }
        }
    }
}
