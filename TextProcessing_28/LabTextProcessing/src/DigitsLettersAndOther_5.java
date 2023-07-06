import java.util.Scanner;

public class DigitsLettersAndOther_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String text = reader.nextLine();

        StringBuilder digitsSb = new StringBuilder();
        StringBuilder lettersSb = new StringBuilder();
        StringBuilder charactersSb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            if (Character.isDigit(text.charAt(i))) {
                digitsSb.append(text.charAt(i));
            } else if (Character.isLetter(text.charAt(i))) {
                lettersSb.append(text.charAt(i));
            } else {
                charactersSb.append(text.charAt(i));
            }
        }

        System.out.println(digitsSb);
        System.out.println(lettersSb);
        System.out.println(charactersSb);
    }
}
