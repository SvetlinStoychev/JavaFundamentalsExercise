import java.util.Scanner;

public class CharactersInRange_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        char start = reader.nextLine().charAt(0);
        char stop = reader.nextLine().charAt(0);

        printsAllCharactersBetween(start, stop);
    }

    public static void printsAllCharactersBetween(char start, char stop) {
        int startNum = start;
        int stopNum = stop;

        if (startNum > stopNum) {
            startNum = stop;
            stopNum = start;
        }
        for (int i = startNum + 1; i < stopNum ; i++) {
            char currentChar = (char)i;
            System.out.printf("%s ", currentChar);
        }
    }
}
