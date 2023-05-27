import java.util.Scanner;

public class CommonElements_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String firstInput = reader.nextLine();
        String secondInput = reader.nextLine();

        String[] firstArr = firstInput.split(" ");
        String[] secondArr = secondInput.split(" ");

        for (int i = 0; i < secondArr.length; i++) {
            for (int j = 0; j < firstArr.length; j++) {
                if (secondArr[i].equals(firstArr[j])) {
                    System.out.printf("%s ", secondArr[i]);
                }
            }
        }
    }
}
