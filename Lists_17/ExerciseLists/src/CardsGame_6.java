import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Integer> firstPlayer = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondPlayer = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstPlayer.size() > 0 && secondPlayer.size() > 0) {
            int firstPlayerCurrentCard = firstPlayer.get(0);
            firstPlayer.remove(0);
            int secondPlayerCurrentCard = secondPlayer.get(0);
            secondPlayer.remove(0);

            if (firstPlayerCurrentCard > secondPlayerCurrentCard) {
                firstPlayer.add(firstPlayerCurrentCard);
                firstPlayer.add(secondPlayerCurrentCard);
            } else if (secondPlayerCurrentCard > firstPlayerCurrentCard) {
                secondPlayer.add(secondPlayerCurrentCard);
                secondPlayer.add(firstPlayerCurrentCard);
            }
        }

        int sum = 0;
        if (firstPlayer.size() == 0) {
            sum = calculateSumOfCards(secondPlayer);
            System.out.println("Second player wins! Sum: " + sum);
        } else if (secondPlayer.size() == 0) {
            sum = calculateSumOfCards(firstPlayer);
            System.out.println("First player wins! Sum: " + sum);
        } else {
            System.out.println("W.T.F happen here ?");
        }
    }

    private static int calculateSumOfCards(List<Integer> playerCards) {
        int sum = 0;
        for (int i = 0; i < playerCards.size(); i++) {
            sum += playerCards.get(i);
        }
        return sum;
    }
}
