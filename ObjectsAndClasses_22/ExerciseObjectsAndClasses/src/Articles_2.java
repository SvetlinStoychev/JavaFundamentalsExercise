import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Articles_2 {
    public static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }
        public String getTitle() {
            return this.title;
        }

        public String getContent() {
            return this.content;
        }
        public String getAuthor() {
            return this.author;
        }
        public void edit(String newContent) {
            this.content = newContent;
        }
        public void changeAuthor(String newAuthor) {
            this.author = newAuthor;
        }
        public void rename(String newTitle) {
            this.title = newTitle;
        }

    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] userInput = reader.nextLine().split(", ");
        String title = userInput[0];
        String content = userInput[1];
        String author = userInput[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(reader.nextLine());

        for (int i = 0; i < n; i++) {
            List<String> commandList = Arrays.stream(reader.nextLine().split(" ")).collect(Collectors.toList());
            String command = commandList.get(0);
            commandList.remove(0);
            String newData = String.join(" ", commandList);

            switch (command) {
                case "Edit:":
                    article.edit(newData);
                    break;
                case "ChangeAuthor:":
                    article.changeAuthor(newData);
                    break;
                case "Rename:":
                    article.rename(newData);
                    break;
                default:
                    System.out.println("W.T.F is " + command);
                    break;
            }
        }

        System.out.printf("%s - %s: %s", article.getTitle(), article.getContent(), article.getAuthor());
    }
}
