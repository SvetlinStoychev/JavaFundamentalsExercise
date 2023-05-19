import java.util.Scanner;

public class ConcatNames_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String fName = reader.nextLine();
        String lName = reader.nextLine();
        String delimiter = reader.nextLine();

        String result = fName + delimiter + lName;

        System.out.println(result);
    }
}
