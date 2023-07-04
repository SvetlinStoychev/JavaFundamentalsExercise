import java.util.*;

public class MOBAChallenger_3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String command = reader.nextLine();

        TreeMap<String, TreeMap<String, Integer>> playerPoolMap = new TreeMap<>();

        while (!command.equals("Season end")) {
            //  {player} -> {position} -> {skill}
            //  {player} vs {player}
            String[] commandsArr = command.split(" ");
            String inputPlayer = commandsArr[0];
            String inputCommand = commandsArr[1];

            TreeMap<String, Integer> currentPositionSkillMap = new TreeMap<>();

            switch (inputCommand) {
                case "->":
                    String inputPosition = commandsArr[2];
                    int inputSkill = Integer.parseInt(commandsArr[4]);

                    if (!playerPoolMap.containsKey(inputPlayer)) {
                        currentPositionSkillMap.put(inputPosition, inputSkill);
                        playerPoolMap.put(inputPlayer, currentPositionSkillMap);
                    } else {
                        currentPositionSkillMap = playerPoolMap.get(inputPlayer);

                        if (!currentPositionSkillMap.containsKey(inputPosition)) {
                            currentPositionSkillMap.put(inputPosition, inputSkill);
                        } else {
                            int currentSkill = currentPositionSkillMap.get(inputPosition);

                            if (inputSkill > currentSkill) {
                                currentPositionSkillMap.put(inputPosition, inputSkill);
                            }
                        }

                        playerPoolMap.put(inputPlayer, currentPositionSkillMap);
                    }
                    break;
                case "vs":
                    String inputPlayerTwo = commandsArr[2];
                    TreeMap<String, Integer> playerOnePositionSkill = new TreeMap<>();
                    TreeMap<String, Integer> playerTwoPositionSkill = new TreeMap<>();

                    if (playerPoolMap.containsKey(inputPlayer) && playerPoolMap.containsKey(inputPlayerTwo)) {
                        playerOnePositionSkill = playerPoolMap.get(inputPlayer);
                        playerTwoPositionSkill = playerPoolMap.get(inputPlayerTwo);

                        int playerOneSkill = 0;
                        int playerTwoSkill = 0;

                        for (Map.Entry<String, Integer> entry : playerOnePositionSkill.entrySet()) {
                            for (Map.Entry<String, Integer> integerEntry : playerTwoPositionSkill.entrySet()) {
                                if (entry.getKey().equals(integerEntry.getKey())) {
                                    playerOneSkill += entry.getValue();
                                    playerTwoSkill += integerEntry.getValue();
                                }
                            }
                        }

                        if (playerOneSkill != 0) {
                            if (playerOneSkill > playerTwoSkill) {
                                playerPoolMap.remove(inputPlayerTwo);
                            } else if (playerTwoSkill > playerOneSkill) {
                                playerPoolMap.remove(inputPlayer);
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("W.T.F is " + inputCommand);
            }
            command = reader.nextLine();
        }

        TreeMap<String, Integer> totalSkillMap = new TreeMap<>();

        for (Map.Entry<String, TreeMap<String, Integer>> entry : playerPoolMap.entrySet()) {
            int currentPlayerSkill = 0;
            for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                currentPlayerSkill += integerEntry.getValue();
            }
            totalSkillMap.put(entry.getKey(), currentPlayerSkill);
        }

        ArrayList<Integer> skillList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : totalSkillMap.entrySet()) {
            skillList.add(entry.getValue());
        }

        Collections.sort(skillList);
        Collections.reverse(skillList);

        ArrayList<String> printed = new ArrayList<>();

        for (Integer skill : skillList) {

            for (Map.Entry<String, Integer> entry : totalSkillMap.entrySet()) {
                if (skill.equals(entry.getValue()) && (!printed.contains(entry.getKey()))) {
                    printed.add(entry.getKey());
                    System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue());

                    TreeMap<String, Integer> currentPositionSkillMap = playerPoolMap.get(entry.getKey());

                    ArrayList<Integer> points = new ArrayList<>();

                    for (Map.Entry<String, Integer> integerEntry : currentPositionSkillMap.entrySet()) {
                        points.add(integerEntry.getValue());
                    }

                    Collections.sort(points);
                    Collections.reverse(points);

                    ArrayList<String> printedTwo = new ArrayList<>();

                    for (Integer point : points) {
                        for (Map.Entry<String, Integer> integerEntry : currentPositionSkillMap.entrySet()) {
                            if (point.equals(integerEntry.getValue()) && (!printedTwo.contains(integerEntry.getKey()))) {
                                printedTwo.add(integerEntry.getKey());
                                System.out.printf("- %s <::> %d%n", integerEntry.getKey(), integerEntry.getValue());
                            }
                        }
                    }
                }
            }
        }
    }
}
