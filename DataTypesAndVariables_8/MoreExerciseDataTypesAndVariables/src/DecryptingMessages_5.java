import java.util.Scanner;

public class DecryptingMessages_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int key = Integer.parseInt(reader.nextLine());
        int n = Integer.parseInt(reader.nextLine());

        String decryptedMessage = "";
        for (int i = 0; i < n; i++) {
            char inputChar = reader.nextLine().charAt(0);
            decryptedMessage += (char) (inputChar + key);
        }

        System.out.println(decryptedMessage);
    }
}
