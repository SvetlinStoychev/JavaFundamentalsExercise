import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int[] keysArr = Arrays.stream(reader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String text = reader.nextLine();

       while (!text.equals("find")) {
           StringBuilder result = new StringBuilder();
           int keyCnt = 0;

           for (int i = 0; i < text.length(); i++) {

               if (keyCnt == keysArr.length) {
                   keyCnt = 0;
               }
                result.append((char)(text.charAt(i) - keysArr[keyCnt]));
                keyCnt++;
           }

           String type = result.substring(result.indexOf("&") + 1, result.lastIndexOf("&"));
           String coordinates = result.substring(result.indexOf("<") + 1, result.indexOf(">"));

           System.out.printf("Found %s at %s%n", type, coordinates);

           text = reader.nextLine();
       }
    }
}
