import java.util.Scanner;

public class CounterStrike_4_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int energy = Integer.parseInt(reader.nextLine());
        String command = reader.nextLine();

        int battleCnt = 0;
        boolean isEndOfBattle = true;

        while (!command.equals("End of battle")) {
            int distance = Integer.parseInt(command);

            if (energy >= distance) {
                battleCnt++;
                energy -= distance;

                if (battleCnt % 3 == 0) {
                    energy += battleCnt;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", battleCnt, energy);
                isEndOfBattle = false;
                break;
            }

            command = reader.nextLine();
        }

        if (isEndOfBattle) {
            System.out.printf("Won battles: %d. Energy left: %d", battleCnt, energy);
        }
    }
}
