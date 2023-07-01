import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ForceBook_9 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();

        LinkedHashMap<String, ArrayList<String>> forceBookMap = new LinkedHashMap<>();

        while (!command.equals("Lumpawaroo")) {

            if (command.contains("|")) {

                String[] commandsArr = command.split(" \\| ");
                String forceSide = commandsArr[0];
                String forceUser = commandsArr[1];

                if (!forceBookMap.containsKey(forceSide)) {

                    forceBookMap.put(forceSide, new ArrayList<>());
                }

                boolean isExist = false;

                for (ArrayList<String> user : forceBookMap.values()) {

                    if (user.contains(forceUser)) {

                        isExist = true;
                        break;
                    }
                }

                if (!isExist) {

                    forceBookMap.get(forceSide).add(forceUser);
                }

            } else if (command.contains("->")) {

                String[] commandsArr = command.split(" -> ");
                String forceUser = commandsArr[0];
                String forceSide = commandsArr[1];

                forceBookMap.entrySet().forEach(entryForceSide -> entryForceSide.getValue().remove(forceUser));

                if (!forceBookMap.containsKey(forceSide)) {

                    forceBookMap.put(forceSide, new ArrayList<>());
                }

                forceBookMap.get(forceSide).add(forceUser);

                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }
         command = reader.nextLine();
        }

        for (Map.Entry<String, ArrayList<String>> entry : forceBookMap.entrySet()) {

            if (entry.getValue().size() != 0) {

                System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());

                for (String user : entry.getValue()) {

                    System.out.printf("! %s%n", user);
                }
            }
        }
    }
}
