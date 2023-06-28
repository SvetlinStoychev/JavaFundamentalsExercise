package OddTimes_5;

import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int[] numbers = Arrays.stream(reader.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            result = result ^ numbers[i];
        }

        System.out.println(result);
    }
}
