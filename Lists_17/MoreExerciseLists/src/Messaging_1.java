import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<String> text = Arrays.stream(reader.nextLine().split(""))
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size(); i++) {
            int textIndex = calculateSumOfDigits(numbers.get(i));

            if (textIndex > text.size() - 1) {
                while (textIndex > text.size() - 1) {
                    textIndex -= text.size();
                }
            }

            String currentElement = text.get(textIndex);
            System.out.print(currentElement);
            text.remove(textIndex);
        }
    }

    private static int calculateSumOfDigits(Integer number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
