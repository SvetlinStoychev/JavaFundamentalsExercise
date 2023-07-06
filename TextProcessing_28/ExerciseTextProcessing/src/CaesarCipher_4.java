import java.util.Scanner;

public class CaesarCipher_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String text = reader.nextLine();
        char[] textArr = text.toCharArray();

        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < textArr.length; i++) {
            char encryptedChar = (char) (textArr[i] + 3);
            encryptedText.append(encryptedChar);
        }

        System.out.println(encryptedText);
    }
}
