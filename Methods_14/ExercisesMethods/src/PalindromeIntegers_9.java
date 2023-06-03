import java.util.Scanner;

public class PalindromeIntegers_9 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();

        while (!input.equals("END")) {

            if(isPalindrome(input)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            input = reader.nextLine();
        }
    }

    public static boolean isPalindrome(String n) {
        boolean result = false;
        if (n.length() == 1) {
            result = true;
            return result;
        }
        for (int i = 0; i < n.length() / 2; i++) {
            int lastIndex = n.length() - 1 - i;
            if (n.charAt(i) == n.charAt(lastIndex)) {
                result = true;
            } else {
                result = false;
                return result;
            }
        }
        return result;
    }
}
