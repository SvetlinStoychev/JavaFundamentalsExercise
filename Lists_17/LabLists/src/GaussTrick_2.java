import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String input = reader.nextLine();
        List<Integer> listInput = Arrays
                .stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int halfSize = listInput.size() / 2;
        for (int i = 0; i < halfSize; i++) {
            int firstNum = listInput.get(i);
            int lastNum = listInput.get(listInput.size() - 1);
            int sum = firstNum + lastNum;

            listInput.set(i, sum);
            listInput.remove(listInput.size() - 1);
        }

        for (int i = 0; i < listInput.size(); i++) {
            int currentNum = listInput.get(i);
            System.out.printf("%d ", currentNum);
        }
    }
}
