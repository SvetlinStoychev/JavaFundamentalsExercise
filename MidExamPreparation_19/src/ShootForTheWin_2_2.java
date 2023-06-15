import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin_2_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Integer> targetsSequence = Arrays.stream(reader.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = reader.nextLine();

        int shotTargetsCnt = 0;

        while (!command.equals("End")) {
            int indexOfTarget = Integer.parseInt(command);

            if (indexOfTarget >= 0 && indexOfTarget < targetsSequence.size()) {
                if (targetsSequence.get(indexOfTarget) != -1) {
                    int targetValue = targetsSequence.get(indexOfTarget);
                    targetsSequence.set(indexOfTarget, -1);
                    shotTargetsCnt++;

                    for (int i = 0; i < targetsSequence.size(); i++) {
                        int newTargetValue;
                        if (targetsSequence.get(i) <= targetValue && targetsSequence.get(i) != -1) {
                            newTargetValue = targetValue + targetsSequence.get(i);
                            targetsSequence.set(i, newTargetValue);
                        } else if (targetsSequence.get(i) > targetValue && targetsSequence.get(i) != -1) {
                            newTargetValue = targetsSequence.get(i) - targetValue;
                            targetsSequence.set(i, newTargetValue);
                        }
                    }
                }
            }

            command = reader.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", shotTargetsCnt);
        System.out.println(targetsSequence.toString().replaceAll("[\\[\\],]", ""));
    }
}
