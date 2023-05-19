import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();
        String result = "result";

        switch(input) {
            case "England":
            case "USA":
                result = "English";
            break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                result = "Spanish";
                break;
            default:
                result = "unknown";
        }

        System.out.println(result);
    }
}
