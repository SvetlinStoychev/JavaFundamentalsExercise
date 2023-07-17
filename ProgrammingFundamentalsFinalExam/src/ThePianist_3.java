import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        LinkedHashMap<String, String[]> pieceComposerKeyMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] pieceInfoArr = reader.nextLine().split("\\|");
            String piece = pieceInfoArr[0];
            String[] composerKeyArr = new String[2];
            composerKeyArr[0] = pieceInfoArr[1];
            composerKeyArr[1] = pieceInfoArr[2];

            pieceComposerKeyMap.put(piece, composerKeyArr);
        }

        String command = reader.nextLine();

        while (!command.equals("Stop")) {
            String[] commandArr = command.split("\\|");
            String currentCommand = commandArr[0];
            String piece = commandArr[1];

            switch (currentCommand) {
                case "Add":
                    if (pieceComposerKeyMap.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        String[] composerKeyArr = new String[2];
                        composerKeyArr[0] = commandArr[2];
                        composerKeyArr[1] = commandArr[3];
                        pieceComposerKeyMap.put(piece, composerKeyArr);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, commandArr[2], commandArr[3]);
                    }
                    break;
                case "Remove":
                    if (pieceComposerKeyMap.containsKey(piece)) {
                        pieceComposerKeyMap.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                case "ChangeKey":
                    if (pieceComposerKeyMap.containsKey(piece)) {
                        String[] currentComposerKeyArr = pieceComposerKeyMap.get(piece);
                        currentComposerKeyArr[1] = commandArr[2];
                        pieceComposerKeyMap.put(piece, currentComposerKeyArr);
                        System.out.printf("Changed the key of %s to %s!%n", piece, commandArr[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
            }
            command = reader.nextLine();
        }

        for (Map.Entry<String, String[]> entry : pieceComposerKeyMap.entrySet()) {
            String piece = entry.getKey();
            String[] composerKeyArr = entry.getValue();
            String composer = composerKeyArr[0];
            String key = composerKeyArr[1];
            System.out.printf("%s -> Composer: %s, Key: %s%n", piece, composer, key);
        }
    }
}
