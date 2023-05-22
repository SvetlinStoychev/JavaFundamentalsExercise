import javax.swing.*;
import java.util.Scanner;

public class BalancedBrackets_6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        int openBracketCnt = 0;
        int closeBracketCnt = 0;
        String previousBracket = "";
        for (int i = 0; i < n; i++) {
            String userInput = reader.nextLine();

            if (userInput.equals("(")) {
                openBracketCnt++;
                if (previousBracket.equals("(")) {
                    break;
                } else {
                    previousBracket = "(";
                }
            } else if (userInput.equals(")")) {
                closeBracketCnt++;
                if (previousBracket.equals(")")) {
                    break;
                } else {
                    previousBracket = ")";
                }
            }
        }

        if (openBracketCnt == closeBracketCnt) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
