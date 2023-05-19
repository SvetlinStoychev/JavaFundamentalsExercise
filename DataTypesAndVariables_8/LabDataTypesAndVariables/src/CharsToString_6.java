import java.util.Scanner;

public class CharsToString_6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        char one = reader.nextLine().charAt(0);
        char two = reader.nextLine().charAt(0);
        char three = reader.nextLine().charAt(0);

        String result = Character.toString(one) + Character.toString(two) + Character.toString(three);

        System.out.println(result);
    }
}
