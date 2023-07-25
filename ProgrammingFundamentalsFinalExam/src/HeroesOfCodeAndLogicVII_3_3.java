import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII_3_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        LinkedHashMap<String, Integer> hitMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> manaMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArr = reader.nextLine().split(" ");
            // {hero name} {HP} {MP}
            String name = inputArr[0];
            int hit = Integer.parseInt(inputArr[1]);
            int mana = Integer.parseInt(inputArr[2]);
            hitMap.put(name, hit);
            manaMap.put(name, mana);
        }

        String command = reader.nextLine();

        while (!command.equals("End")) {
            String[] commandsArr = command.split("\\ \\-\\ ");
            String currentCommand = commandsArr[0];
            String name = commandsArr[1];

            switch (currentCommand) {
                case "CastSpell": {
                    // CastSpell – {hero name} – {MP needed} – {spell name}"
                    // If the hero has the required MP, he casts the spell, thus reducing his MP. Print this message:
                    // "{hero name} has successfully cast {spell name} and now has {mana pointsleft} MP!"
                    // If the hero is unable to cast the spell print:
                    // "{hero name} does not have enough MP to cast {spell name}!"
                    int manaNeeded = Integer.parseInt(commandsArr[2]);
                    String spellName = commandsArr[3];

                    if (manaMap.get(name) >= manaNeeded) {
                        manaMap.put(name, manaMap.get(name) - manaNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spellName, manaMap.get(name));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                    }
                    break;
                }
                case "TakeDamage": {
                    // TakeDamage – {hero name} – {damage} – {attacker}"
                    // Reduce the hero HP by the given damage amount. If the hero is still alive (his HP is greater than 0) print:
                    // "{hero name} was hit for {damage} HP by {attacker} and now has {currentHP} HP left!"
                    // If the hero has died, remove him from your party and print:
                    // "{hero name} has been killed by {attacker}!"
                    int damage = Integer.parseInt(commandsArr[2]);
                    String attacker = commandsArr[3];
                    hitMap.put(name, hitMap.get(name) - damage);

                    if (hitMap.get(name) > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", name, damage, attacker, hitMap.get(name));
                    } else {
                        hitMap.remove(name);
                        manaMap.remove(name);
                        System.out.printf("%s has been killed by %s!%n", name, attacker);
                    }
                    break;
                }
                case "Recharge": {
                    // Recharge – {hero name} – {amount}"
                    // The hero increases his MP. If it brings the MP of the hero above the maximum value (200), MP is increased
                    //to 200. (the MP can't go over the maximum value).
                    // Print the following message:
                    // "{hero name} recharged for {amount recovered} MP!"
                    int amount = Integer.parseInt(commandsArr[2]);
                    manaMap.put(name, manaMap.get(name) + amount);

                    if (manaMap.get(name) > 200) {
                        amount = amount - (manaMap.get(name) - 200);
                        manaMap.put(name, 200);
                    }

                    System.out.printf("%s recharged for %d MP!%n", name, amount);
                    break;
                }
                case "Heal": {
                    // Heal – {hero name} – {amount}"
                    //  The hero increases his HP. If a command is given that would bring the HP of the hero above the maximum
                    //value (100), HP is increased to 100 (the HP can't go over the maximum value).
                    // Print the following message:
                    // "{hero name} healed for {amount recovered} HP!"
                    int amount = Integer.parseInt(commandsArr[2]);
                    hitMap.put(name, hitMap.get(name) + amount);

                    if (hitMap.get(name) > 100) {
                        amount = amount - (hitMap.get(name) - 100);
                        hitMap.put(name, 100);
                    }

                    System.out.printf("%s healed for %d HP!%n", name, amount);
                    break;
                }
                default:
                    System.out.println("W.T.F is " + currentCommand);
            }

            command = reader.nextLine();
        }

        for (Map.Entry<String, Integer> entry : hitMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.printf("  HP: %d%n", entry.getValue());
            System.out.printf("  MP: %d%n", manaMap.get(entry.getKey()));
        }
    }
}
