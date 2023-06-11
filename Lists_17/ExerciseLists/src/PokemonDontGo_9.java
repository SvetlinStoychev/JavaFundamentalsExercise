import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo_9 {
    private static List<Integer> distanceList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        distanceList = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int index = Integer.parseInt(reader.nextLine());
        int sum = 0;

        while (distanceList.size() >= 1) {
            int removedElement = 0;
            if (index < 0) {
                removedElement = distanceList.get(0);
                sum += removedElement;
                int lastElement = distanceList.get(distanceList.size() - 1);
                distanceList.remove(0);
                distanceList.add(0, lastElement);
                increasingAndDecreasing(removedElement);
            } else if (index > distanceList.size() - 1) {
                removedElement = distanceList.get(distanceList.size() - 1);
                sum += removedElement;
                int firstElement = distanceList.get(0);
                distanceList.remove(distanceList.size() - 1);
                distanceList.add(distanceList.size(), firstElement);
                increasingAndDecreasing(removedElement);
            } else {
                removedElement = distanceList.get(index);
                sum += removedElement;
                distanceList.remove(index);
                increasingAndDecreasing(removedElement);
            }

            if (distanceList.size() == 0) {
                break;
            }

            index = Integer.parseInt(reader.nextLine());
        }

        System.out.println(sum);
    }

    private static void increasingAndDecreasing(int distance) {
        for (int i = 0; i < distanceList.size(); i++) {
            int currentDistance = distanceList.get(i);
            if (distance >= currentDistance) {
                currentDistance += distance;
                distanceList.set(i, currentDistance);
            } else {
                currentDistance -= distance;
                distanceList.set(i, currentDistance);
            }
        }
    }
}
