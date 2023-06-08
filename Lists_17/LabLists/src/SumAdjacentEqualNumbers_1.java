import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Double> inputNums = Arrays
                .stream(reader.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < inputNums.size() - 1; i++) {
            double currentNum = inputNums.get(i);
            double nextNum = inputNums.get(i + 1);

            if (currentNum == nextNum) {
                double sum = currentNum + nextNum;
                inputNums.remove(i);
                inputNums.set(i, sum);
                i = -1;
            }
        }

        String result = joinElementsByDelimiter(inputNums, " ");
        System.out.println(result);
    }

    private static String joinElementsByDelimiter(List<Double> numList, String delimiter) {
        String result = "";
        DecimalFormat df = new DecimalFormat("0.#");

        for (int i = 0; i < numList.size(); i++) {
            result += df.format(numList.get(i)) + delimiter;
        }

        return result;
    }
}
