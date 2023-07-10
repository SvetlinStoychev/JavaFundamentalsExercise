import java.util.Scanner;

public class ExtractPersonInformation_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        for (int i = 0; i < n; i++) {
            String text = reader.nextLine();

            String name = text.substring(text.indexOf("@") + 1, text.indexOf("|"));
            String age = text.substring(text.indexOf("#") + 1, text.indexOf("*"));

            System.out.printf("%s is %s years old.%n", name, age);
        }
    }
}
