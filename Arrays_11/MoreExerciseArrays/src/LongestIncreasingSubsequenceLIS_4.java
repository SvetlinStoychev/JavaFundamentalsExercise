import java.util.Scanner;

public class LongestIncreasingSubsequenceLIS_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userInput = reader.nextLine();
        String[] inputArr = userInput.split(" ");
        int[] numbers = new int[inputArr.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputArr[i]);
        }

        int[] len = new int[numbers.length];
        int[] prev = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {

            len[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i] && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int maxLenIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (len[i] > len[maxLenIndex]) {
                maxLenIndex = i;
            }
        }

        int[] result = new int[len[maxLenIndex]];
        int resultIndex = result.length - 1;
        int index = maxLenIndex;
        while (index != -1) {
            result[resultIndex] = numbers[index];
            index = prev[index];
            resultIndex--;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%d ", result[i]);
        }
    }
}
