import java.util.Scanner;

public class MultiplyBigNumber_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String bigNumber = reader.nextLine();
        int singleDigit = Integer.parseInt(reader.nextLine());

        if (singleDigit == 0 || bigNumber.equals("0")) {
            System.out.println(0);
        } else {
            int carry = 0;
            StringBuilder result = new StringBuilder();
            int n = bigNumber.length();

            for (int i = n - 1; i >= 0 ; i--) {
                int digit = bigNumber.charAt(i) - '0';
                int product = digit * singleDigit + carry;
                carry = product / 10;
                result.insert(0, product % 10);
            }

            if (carry > 0) {
                result.insert(0, carry);
            }

            System.out.println(result);
        }
    }
}



