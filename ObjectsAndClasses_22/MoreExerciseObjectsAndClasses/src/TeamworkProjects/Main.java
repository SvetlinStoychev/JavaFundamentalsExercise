package TeamworkProjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        List<Team> teamList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] teamData = reader.nextLine().split("-");
            String user = teamData[0];
            String team = teamData[1];

            if (teamList.size() == 0) {
                teamList.add(new Team(user, team));
                System.out.printf("Team %s has been created by %s!%n", team, user);
            }

            for (int j = 0; j < teamList.size(); j++) {
                if (teamList.get(j).getName().equals(team)) {
                    System.out.printf("Team %s was already created!%n", team);
                } else if(teamList.get(j).getCreator().equals(user)) {
                    System.out.printf("%s cannot create another team!", user);
                } else {
                    teamList.add(new Team(user, team));
                    System.out.printf("Team %s has been created by %s!%n", team, user);
                }
            }
        }

        String command = reader.nextLine();

        while (!command.equals("end of assignment")) {
            String[] commandArr = command.split("->");
            String user = commandArr[0];
            String team = commandArr[1];

            

            command = reader.nextLine();
        }
    }
}
