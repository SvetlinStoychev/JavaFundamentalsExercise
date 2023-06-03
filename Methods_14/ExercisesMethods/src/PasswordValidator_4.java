import java.util.Scanner;

public class PasswordValidator_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String inputPass = reader.nextLine();
        checkPasswordIsValid(inputPass);
    }
    public static void checkPasswordIsValid(String password) {
        if (consistOnlyLettersAndDigits(password) &&
                haveLeastTwoDigits(password) && betweenSixAndTenCharacters(password)) {
            System.out.println("Password is valid");
        } else {
            if (!betweenSixAndTenCharacters(password)) {
                System.out.println("Password must be between 6 and 10 characters");
            }

            if (!consistOnlyLettersAndDigits(password)) {
                System.out.println("Password must consist only of letters and digits");
            }

            if (!haveLeastTwoDigits(password)) {
                System.out.println("Password must have at least 2 digits");
            }
        }
    }

    public static boolean betweenSixAndTenCharacters(String pass) {
        if (pass.length() >= 6 && pass.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean haveLeastTwoDigits(String password) {
        int digitCnt = 0;

        for (int i = 0; i < password.length(); i++) {
            char currChar = password.charAt(i);
            if (currChar >= 48 && currChar <= 57) {
                digitCnt++;
            }
        }

        if (digitCnt >= 2) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean consistOnlyLettersAndDigits(String pass) {
        boolean result = false;

        for (int i = 0; i < pass.length(); i++) {
            int currentChar = pass.charAt(i);

            if (currentChar >= 48 && currentChar <= 57) {
                result = true;
            } else if (currentChar >= 65 && currentChar <= 90) {
                result = true;
            } else if(currentChar >= 97 && currentChar <= 122) {
                result = true;
            } else {
                result = false;
                return result;
            }
        }
        return result;
    }
}
