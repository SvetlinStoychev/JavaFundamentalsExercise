import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Integer> racerTrack = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

       int finishIndex = racerTrack.size() / 2;
       List<Integer> leftRacerStages = new ArrayList<>();
       List<Integer> rightRacerStages = new ArrayList<>();

        for (int i = 0; i < racerTrack.size(); i++) {
            if (i < finishIndex) {
                leftRacerStages.add(racerTrack.get(i));
            } else if(i > finishIndex) {
                rightRacerStages.add(0, racerTrack.get(i));
            }
        }

        double leftRacerTime = calculateRacerTime(leftRacerStages);
        double rightRacerTime = calculateRacerTime(rightRacerStages);

        if (leftRacerTime < rightRacerTime) {
            System.out.printf("The winner is left with total time: %.1f", leftRacerTime);
        } else if (rightRacerTime < leftRacerTime) {
            System.out.printf("The winner is right with total time: %.1f", rightRacerTime);
        }
    }

    private static double calculateRacerTime(List<Integer> racerStages) {
        double resultTime = 0;
        for (int i = 0; i < racerStages.size(); i++) {
            double currentStage = racerStages.get(i);
            if (currentStage == 0) {
                resultTime *= 0.8;
            } else {
                resultTime += currentStage;
            }
        }
        return resultTime;
    }
}
