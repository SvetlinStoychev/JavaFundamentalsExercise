import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int capacity = Integer.parseInt(reader.nextLine());
        String command = reader.nextLine();
        LinkedHashMap<String, Integer> messageCntMap = new LinkedHashMap<>();

        while (!command.equals("Statistics")) {
            String[] commandsArr = command.split("=");
            String currentCommand = commandsArr[0];

            switch (currentCommand) {
                case "Add": {
                    // "Add={username}={sent}={received}
                    String userName = commandsArr[1];
                    int sent = Integer.parseInt(commandsArr[2]);
                    int received = Integer.parseInt(commandsArr[3]);
                    int totalMessage = sent + received;

                    if (!messageCntMap.containsKey(userName)) {
                        messageCntMap.put(userName, totalMessage);
                    }
                }
                    break;
                case "Message": {
                    // Message={sender}={receiver}
                    String sender = commandsArr[1];
                    String receiver = commandsArr[2];

                    if (messageCntMap.containsKey(sender) && messageCntMap.containsKey(receiver)) {
                        messageCntMap.put(sender, messageCntMap.get(sender) + 1);
                        messageCntMap.put(receiver, messageCntMap.get(receiver) + 1);

                        if (messageCntMap.get(sender) >= capacity) {
                            messageCntMap.remove(sender);
                            System.out.printf("%s reached the capacity!%n", sender);
                        }

                        if (messageCntMap.get(receiver) >= capacity) {
                            messageCntMap.remove(receiver);
                            System.out.printf("%s reached the capacity!%n", receiver);
                        }
                    }
                }
                    break;
                case "Empty": {
                    // Empty={username}
                    String userName = commandsArr[1];

                    if (messageCntMap.containsKey(userName)) {
                        messageCntMap.remove(userName);
                    } else if (userName.equals("All")) {
                        messageCntMap.clear();
                    }
                }
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }

            command = reader.nextLine();
        }

        System.out.println("Users count: " + messageCntMap.size());

        for (Map.Entry<String, Integer> entry : messageCntMap.entrySet()) {
            String name = entry.getKey();
            int cnt = entry.getValue();

            System.out.printf("%s - %d%n", name, cnt);
        }
    }
}
