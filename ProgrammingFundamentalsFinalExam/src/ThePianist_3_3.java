import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist_3_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        LinkedHashMap<String, String> composerMap = new LinkedHashMap<>();
        LinkedHashMap<String, String> keyMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] currentPieceArr = reader.nextLine().split("\\|");
            // "{piece}|{composer}|{key}
            String piece = currentPieceArr[0];
            String composer = currentPieceArr[1];
            String key = currentPieceArr[2];

            composerMap.put(piece, composer);
            keyMap.put(piece, key);
        }

        String command = reader.nextLine();

        while (!command.equals("Stop")) {
            String[] commandsArr = command.split("\\|");
            String currentCommand = commandsArr[0];
            String piece = commandsArr[1];

            switch (currentCommand) {
                case "Add": {
                    // Add|{piece}|{composer}|{key}":
                    //	You need to add the given piece with the information about it to the other
                    // pieces and print:
                    //"{piece} by {composer} in {key} added to the collection!"
                    //	If the piece is already in the collection, print:
                    //"{piece} is already in the collection!"
                    if (composerMap.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                    } else {
                        String composer = commandsArr[2];
                        String key = commandsArr[3];
                        composerMap.put(piece, composer);
                        keyMap.put(piece, key);
                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                    }
                    break;
                }
                case "Remove": {
                    // Remove|{piece}":
                    //	If the piece is in the collection, remove it and print:
                    //"Successfully removed {piece}!"
                    //	Otherwise, print:
                    //"Invalid operation! {piece} does not exist in the collection."
                    if (composerMap.containsKey(piece)) {
                        composerMap.remove(piece);
                        keyMap.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                }
                case "ChangeKey": {
                    // ChangeKey|{piece}|{new key}":
                    //	If the piece is in the collection, change its key with the given one and print:
                    //"Changed the key of {piece} to {new key}!"
                    //	Otherwise, print:
                    //"Invalid operation! {piece} does not exist in the collection.
                    if (composerMap.containsKey(piece)) {
                        String key = commandsArr[2];
                        keyMap.put(piece, key);
                        System.out.printf("Changed the key of %s to %s!%n", piece, key);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;
                }
                default:
                    System.out.println("W.T.F is " + currentCommand);
            }

            command = reader.nextLine();
        }

        for (Map.Entry<String, String> entry : composerMap.entrySet()) {
            String piece = entry.getKey();
            String composer = entry.getValue();
            String key = keyMap.get(entry.getKey());

            System.out.printf("%s -> Composer: %s, Key: %s%n", piece, composer, key);
        }
    }
}
