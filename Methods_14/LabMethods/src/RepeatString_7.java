import java.util.Scanner;

public class RepeatString_7 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String inputText = reader.nextLine();
        int inputCnt = Integer.parseInt(reader.nextLine());

        System.out.println(repeatString(inputText, inputCnt));
    }

    public static String repeatString(String text, int cnt) {
        String result = "";
        for (int i = 0; i < cnt; i++) {
            result += text;
        }
        return result;
    }
}
