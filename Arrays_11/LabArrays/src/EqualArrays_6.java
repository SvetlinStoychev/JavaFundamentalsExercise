import java.util.Scanner;

public class EqualArrays_6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInputOne = reader.nextLine();
        String userInputTwo = reader.nextLine();

        String[] strArrOne = userInputOne.split(" ");
        String[] strArrTwo = userInputTwo.split(" ");

        int[] arrOne = new int[strArrOne.length];
        int[] arrTwo = new int[strArrTwo.length];

        for (int i = 0; i < arrOne.length; i++) {
            arrOne[i] = Integer.parseInt(strArrOne[i]);
        }

        for (int i = 0; i < arrTwo.length; i++) {
            arrTwo[i] = Integer.parseInt(strArrTwo[i]);
        }

        int sum = 0;
        int arrIndex = -1;
        for (int i = 0; i < arrOne.length; i++) {
            if (arrOne[i] == arrTwo[i]) {
                sum += arrOne[i];
            } else {
                arrIndex = i;
                break;
            }
        }

        if (arrIndex == -1) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", arrIndex);
        }
    }
}
