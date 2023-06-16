import java.util.Arrays;
import java.util.Scanner;

public class TheLift_3_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(reader.nextLine());
        int[] lift = Arrays.stream(reader.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean isEmptySpaces = false;

        for (int i = 0; i < lift.length; i++) {

            if (lift[i] < 4) {
                int emptySpaces = 4 - lift[i];

                if (emptySpaces <= peopleWaiting) {
                    peopleWaiting -= emptySpaces;
                    lift[i] = 4;
                } else {
                    lift[i] += peopleWaiting;
                    peopleWaiting = 0;
                    isEmptySpaces = true;
                    break;
                }
            }
        }

        if (peopleWaiting == 0 && isEmptySpaces) {
            System.out.println("The lift has empty spots!");
            System.out.println(Arrays.toString(lift).replaceAll("[\\[\\],]", ""));
        } else if (peopleWaiting > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleWaiting);
            System.out.println(Arrays.toString(lift).replaceAll("[\\[\\],]", ""));
        } else {
            System.out.println(Arrays.toString(lift).replaceAll("[\\[\\],]", ""));
        }
    }
}
