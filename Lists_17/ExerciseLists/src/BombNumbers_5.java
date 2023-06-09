import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Integer> numbersList = Arrays
                .stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String inputBombNumber = reader.nextLine();
        String[] bombNumberArr = inputBombNumber.split(" ");
        int bombNumber = Integer.parseInt(bombNumberArr[0]);
        int power = Integer.parseInt(bombNumberArr[1]);

        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) == bombNumber) {
                int positionToRemove = i - power;
                if (positionToRemove < 0) {
                    positionToRemove = 0;
                }
                int timesToRemove = (power * 2) + 1;
                if (timesToRemove > numbersList.size() - positionToRemove) {
                    timesToRemove = numbersList.size() - positionToRemove;
                }
                for (int j = 0; j < timesToRemove; j++) {
                    numbersList.remove(positionToRemove);
                }
                int newStartPosition = positionToRemove - 1;
                if (newStartPosition < 0) {
                    newStartPosition = 0;
                }
                i = newStartPosition;
            }
        }

        int sum = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            sum += numbersList.get(i);
        }

        System.out.println(sum);
    }
}
