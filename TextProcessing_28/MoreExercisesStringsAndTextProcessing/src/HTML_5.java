import java.util.Scanner;

public class HTML_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String title = reader.nextLine();
        String content = reader.nextLine();
        String command = reader.nextLine();

        StringBuilder result = new StringBuilder();

        result.append("<h1>");
        result.append(System.lineSeparator());
        result.append("    " + title);
        result.append(System.lineSeparator());
        result.append("</h1>");
        result.append(System.lineSeparator());

        result.append("<article>");
        result.append(System.lineSeparator());
        result.append("    " + content);
        result.append(System.lineSeparator());
        result.append("</article>");
        result.append(System.lineSeparator());

        while (!command.equals("end of comments")) {
            result.append("<div>");
            result.append(System.lineSeparator());
            result.append("    " + command);
            result.append(System.lineSeparator());
            result.append("</div>");
            result.append(System.lineSeparator());

            command = reader.nextLine();
        }

        System.out.println(result);
    }
}
