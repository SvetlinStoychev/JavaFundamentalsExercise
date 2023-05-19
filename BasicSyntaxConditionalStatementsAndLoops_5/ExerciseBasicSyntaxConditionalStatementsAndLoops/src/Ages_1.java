import java.util.Scanner;

public class Ages_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int age = Integer.parseInt(reader.nextLine());

        if (age <= 2) {
            System.out.println("baby");
        } else if (age <= 13) {
            System.out.println("child");
        } else if (age <= 19) {
            System.out.println("teenager");
        } else if (age <= 65) {
            System.out.println("adult");
        } else {
            System.out.println("elder");
        }
    }
}
