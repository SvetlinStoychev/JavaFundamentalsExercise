import java.util.Arrays;
import java.util.Scanner;

public class WordFilter_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] wordsArr = Arrays.stream(reader.nextLine().split(" "))
                .filter(w -> w.length() % 2 == 0).toArray(String[]::new);

        System.out.println(String.join(System.lineSeparator(), wordsArr));
    }
}
