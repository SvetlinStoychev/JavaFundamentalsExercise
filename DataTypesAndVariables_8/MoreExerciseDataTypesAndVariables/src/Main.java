import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder message = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char encryptedChar = scanner.nextLine().charAt(0);
            char decryptedChar = (char) (encryptedChar - key);
            message.append(decryptedChar);
        }

        System.out.println(message);
    }
}