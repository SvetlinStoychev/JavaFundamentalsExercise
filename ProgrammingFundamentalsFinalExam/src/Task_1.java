import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String spell = reader.nextLine();
        String command = reader.nextLine();

        while (!command.equals("Abracadabra")) {
            String[] commandsArr = command.split(" ");
            String currentCommand = commandsArr[0];

            switch (currentCommand) {
                case "Abjuration": {
                    spell = spell.toUpperCase();
                    System.out.println(spell);
                }
                    break;
                case "Necromancy": {
                    spell = spell.toLowerCase();
                    System.out.println(spell);
                }
                    break;
                case "Illusion": {
                    int index = Integer.parseInt(commandsArr[1]);

                    if (index >= 0 && index < spell.length()) {
                        String letter = commandsArr[2];
                        String firstStr = spell.substring(0, index);
                        String secondStr = spell.substring(index + 1);
                        spell = firstStr.concat(letter).concat(secondStr);
                        System.out.println("Done!");
                    } else {
                        System.out.println("The spell was too weak.");
                    }
                }
                    break;
                case "Divination": {
                    
                }
                    break;
                case "Alteration":
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
                    break;
            }

            command = reader.nextLine();
        }
    }
}
