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
                    String firstSubstring = commandsArr[1];

                    if (spell.contains(firstSubstring)) {
                        String secondSubstring = commandsArr[2];
                        spell = spell.replace(firstSubstring, secondSubstring);
                        System.out.println(spell);
                    }
                }
                    break;
                case "Alteration": {
                    String substring = commandsArr[1];

                    if (spell.contains(substring)) {
                        spell = spell.replace(substring, "");
                        System.out.println(spell);
                    }
                }
                    break;
                default:
                    System.out.println("The spell did not work!");
                    break;
            }

            command = reader.nextLine();
        }
    }
}
