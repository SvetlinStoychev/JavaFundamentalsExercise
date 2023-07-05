import java.util.Scanner;

public class TextFilter_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] bannedWordsArr = reader.nextLine().split(", ");
        String text = reader.nextLine();



        for (int i = 0; i < bannedWordsArr.length; i++) {
            StringBuilder asterisks = new StringBuilder();

            for (int j = 0; j < bannedWordsArr[i].length(); j++) {
                asterisks.append("*");
            }

            text = text.replace(bannedWordsArr[i], asterisks);
        }

        System.out.println(text);
    }
}
