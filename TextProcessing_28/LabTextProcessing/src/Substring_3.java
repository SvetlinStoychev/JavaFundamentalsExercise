import java.util.Scanner;

public class Substring_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String toRemove = reader.nextLine();
        String text = reader.nextLine();

        int index = text.indexOf(toRemove);

        while (index != -1) {
            text = text.replace(toRemove, "");
            index = text.indexOf(toRemove);
        }

        System.out.println(text);
    }
}
