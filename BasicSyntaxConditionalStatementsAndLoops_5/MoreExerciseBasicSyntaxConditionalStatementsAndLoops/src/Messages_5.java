import java.util.Scanner;

public class Messages_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int textLength = Integer.parseInt(reader.nextLine());

        int userNum = 0;
        int  numberOfDigits = 0;
        int  mainDigit = 0;
        int offset = 0;
        int letterIndex = 0;
        int letterIndexToPrint = 0;
        String result = "";

        while (textLength > 0) {

            userNum = Integer.parseInt(reader.nextLine());
            textLength--;

            mainDigit = userNum % 10;

            if (mainDigit == 0) {
                letterIndexToPrint = 32;
            } else {
                while (userNum > 0) {
                    userNum /= 10;
                    numberOfDigits++;
                }

                offset = (mainDigit - 2) * 3;

                if (mainDigit == 8 || mainDigit == 9) {
                    offset++;
                }

                letterIndex = offset + numberOfDigits - 1;
                letterIndexToPrint = 97 + letterIndex;
            }


            result += (char)letterIndexToPrint;

            numberOfDigits = 0;
        }

        System.out.println(result);
    }
}
