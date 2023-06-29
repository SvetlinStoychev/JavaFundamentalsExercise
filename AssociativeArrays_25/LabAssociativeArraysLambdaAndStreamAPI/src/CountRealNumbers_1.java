import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        double[] numbersArr = Arrays.stream(reader.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        TreeMap<Double, Integer> cntMap = new TreeMap<>();

        for (int i = 0; i < numbersArr.length; i++) {

            if (cntMap.containsKey(numbersArr[i])) {
                cntMap.put(numbersArr[i], cntMap.get(numbersArr[i]) + 1);
            } else {
                cntMap.put(numbersArr[i], 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : cntMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
