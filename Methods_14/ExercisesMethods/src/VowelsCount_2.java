import java.util.Scanner;

public class VowelsCount_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();
        printVowelsCount(input);
    }

    public static void printVowelsCount(String text) {
        int cnt = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar == 'a' ||
                    currentChar == 'e' ||
                    currentChar == 'i' ||
                    currentChar == 'o' ||
                    currentChar == 'u' ||
                    currentChar == 'A' ||
                    currentChar == 'E' ||
                    currentChar == 'I' ||
                    currentChar == 'O' ||
                    currentChar == 'U') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
