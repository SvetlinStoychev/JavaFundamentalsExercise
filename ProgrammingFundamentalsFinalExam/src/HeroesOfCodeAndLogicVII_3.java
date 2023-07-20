import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        LinkedHashMap<String, int[]> heroHitManaMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            // "{hero name} {HP} {MP}"
            String[] inputArr = reader.nextLine().split(" ");
            String hero = inputArr[0];
            int[] hitManaArr = new int[2];
            hitManaArr[0] = Integer.parseInt(inputArr[1]);
            hitManaArr[1] = Integer.parseInt(inputArr[2]);
            heroHitManaMap.put(hero, hitManaArr);
        }

        String command = reader.nextLine();

        while (!command.equals("End")) {
            String[] commandsArr = command.split("\\ \\-\\ ");
            String currentCommand = commandsArr[0];
            String hero = commandsArr[1];

            switch (currentCommand) {
                case "CastSpell": {
                    // CastSpell – {hero name} – {MP needed} – {spell name}
                    int[] currentHitManaArr = heroHitManaMap.get(hero);
                    int currentMana = currentHitManaArr[1];
                    int manaNeeded = Integer.parseInt(commandsArr[2]);
                    String spellName = commandsArr[3];

                    if (currentMana >= manaNeeded) {
                        currentMana -= manaNeeded;
                        currentHitManaArr[1] = currentMana;
                        heroHitManaMap.put(hero, currentHitManaArr);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", hero, spellName, currentMana);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", hero, spellName);
                    }
                }
                    break;
                case "TakeDamage": {
                    // TakeDamage – {hero name} – {damage} – {attacker}
                    int damage = Integer.parseInt(commandsArr[2]);
                    String attacker = commandsArr[3];
                    int[] currentHitManaArr = heroHitManaMap.get(hero);
                    int currentHit = currentHitManaArr[0];
                    currentHit -= damage;

                    if (currentHit > 0) {
                        currentHitManaArr[0] = currentHit;
                        heroHitManaMap.put(hero, currentHitManaArr);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", hero, damage, attacker, currentHit);
                    } else {
                        heroHitManaMap.remove(hero);
                        System.out.printf("%s has been killed by %s!%n", hero, attacker);
                    }
                }
                    break;
                case "Recharge": {
                    // Recharge – {hero name} – {amount}
                    int amount = Integer.parseInt(commandsArr[2]);
                    int[] currentHitManaArr = heroHitManaMap.get(hero);
                    int currentMana = currentHitManaArr[1];

                    if (currentMana + amount > 200) {
                        amount = 200 - currentMana;
                        currentHitManaArr[1] = 200;
                        heroHitManaMap.put(hero, currentHitManaArr);
                        System.out.printf("%s recharged for %d MP!%n", hero, amount);
                    } else {
                        System.out.printf("%s recharged for %d MP!%n", hero, amount);
                        currentHitManaArr[1] = currentMana + amount;
                        heroHitManaMap.put(hero, currentHitManaArr);
                    }
                }
                    break;
                case "Heal": {
                    // Heal – {hero name} – {amount}
                    int amount = Integer.parseInt(commandsArr[2]);
                    int[] currentHitManaArr = heroHitManaMap.get(hero);
                    int currentHit = currentHitManaArr[0];

                    if (currentHit + amount > 100) {
                        amount = 100 - currentHit;
                        currentHitManaArr[0] = 100;
                        heroHitManaMap.put(hero, currentHitManaArr);
                        System.out.printf("%s healed for %d HP!%n", hero, amount);
                    } else {
                        System.out.printf("%s healed for %d HP!%n", hero, amount);
                        currentHitManaArr[0] = currentHit + amount;
                        heroHitManaMap.put(hero, currentHitManaArr);
                    }
                }
                    break;
                default:
                    System.out.println("W.T.F is " + currentCommand);
            }
            command = reader.nextLine();
        }
        for (Map.Entry<String, int[]> entry : heroHitManaMap.entrySet()) {
            String hero = entry.getKey();
            int hit = entry.getValue()[0];
            int mana = entry.getValue()[1];
            System.out.println(hero);
            System.out.println("  HP: " + hit);
            System.out.println("  MP: " + mana);
        }
    }
}
