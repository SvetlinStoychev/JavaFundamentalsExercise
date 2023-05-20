import java.util.Scanner;

public class PrintPartOfTheASCIITable_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int startCharIndex = Integer.parseInt(reader.nextLine());
        int endCharIndex = Integer.parseInt(reader.nextLine());

        for (int i = startCharIndex; i <= endCharIndex; i++) {
            System.out.printf("%s ", (char) i);
        }
    }
}
