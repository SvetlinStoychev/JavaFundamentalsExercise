import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExtractFile_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String filePat = reader.nextLine();
        int index = filePat.lastIndexOf('\\');

        StringBuilder sb = new StringBuilder();

        for (int i = index + 1; i < filePat.length(); i++) {
            if (filePat.charAt(i) != '.') {
                sb.append(filePat.charAt(i));
            } else {
                System.out.printf("File name: %s%n", sb);
                sb = new StringBuilder();
            }
        }

        System.out.printf("File extension: %s%n", sb);
    }
}
