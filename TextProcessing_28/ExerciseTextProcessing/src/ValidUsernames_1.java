import java.util.Scanner;

public class ValidUsernames_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] userNameArr = reader.nextLine().split(", ");

        for (int i = 0; i < userNameArr.length; i++) {

            if (isUserNameValid(userNameArr[i])) {
                System.out.println(userNameArr[i]);
            }
        }
    }

    private static boolean isUserNameValid(String s) {

        if (s.length() < 3 || s.length() > 16) {
            return false;
        }

        for (char symbol : s.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '_' && symbol != '-') {
                return false;
            }
        }
        return true;
     }
}
