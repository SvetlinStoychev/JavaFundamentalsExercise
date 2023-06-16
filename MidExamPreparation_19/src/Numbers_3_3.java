import java.util.*;

public class Numbers_3_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int[] numbers = Arrays.stream(reader.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        double average = sum * 1.0 / numbers.length;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (average < numbers[i]) {
                result.add(numbers[i]);
            }
        }

        if (result.size() == 0) {
            System.out.println("No");
        } else {
            Collections.sort(result);
            Collections.reverse(result);

            for (int i = 0; i < result.size(); i++) {

                if (i == 5) {
                    break;
                }

                System.out.printf("%d ", result.get(i));
            }
        }
    }
}
