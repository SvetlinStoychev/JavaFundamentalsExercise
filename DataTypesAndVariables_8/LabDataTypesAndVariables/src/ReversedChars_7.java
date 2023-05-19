import java.util.Scanner;

public class ReversedChars_7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        char one = reader.nextLine().charAt(0);
        char two = reader.nextLine().charAt(0);
        char three = reader.nextLine().charAt(0);

        System.out.printf("%s %s %s", three, two, one);
    }
}
