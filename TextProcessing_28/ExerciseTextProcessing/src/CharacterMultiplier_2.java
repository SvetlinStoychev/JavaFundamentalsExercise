import java.util.Scanner;

public class CharacterMultiplier_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] textArr = reader.nextLine().split("\\s+");
        String firstText = textArr[0];
        String secondText = textArr[1];

        int minLength = Math.min(firstText.length(), secondText.length());
        int maxLength = Math.max(firstText.length(), secondText.length());

        int sum = 0;

        for (int i = 0; i < minLength; i++) {
            sum += (firstText.charAt(i) * secondText.charAt(i));
        }

        if (maxLength == firstText.length()) {
            for (int i = minLength; i < maxLength; i++) {
                sum += firstText.charAt(i);
            }
        } else {
            for (int i = minLength; i < maxLength; i++) {
                sum += secondText.charAt(i);
            }
        }

        System.out.println(sum);
    }
}
