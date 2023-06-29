package TeamworkProjects;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        List<Team> teamList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] teamData = reader.nextLine().split("-");
            String user = teamData[0];
            String team = teamData[1];
            boolean isUserAndTeamLega = true;

            if (teamList.size() == 0) {
                teamList.add(new Team(user, team));
                System.out.printf("Team %s has been created by %s!%n", team, user);
            } else {
                for (int j = 0; j < teamList.size(); j++) {

                    if (teamList.get(j).getName().equals(team)) {
                        System.out.printf("Team %s was already created!%n", team);
                        isUserAndTeamLega = false;
                        break;
                    }

                    if(teamList.get(j).getCreator().equals(user)) {
                        System.out.printf("%s cannot create another team!%n", user);
                        isUserAndTeamLega = false;
                        break;
                    }
                }

                if (isUserAndTeamLega) {
                    teamList.add(new Team(user, team));
                    System.out.printf("Team %s has been created by %s!%n", team, user);
                }
            }
        }

        String command = "";

        while (true) {
            command = reader.nextLine();

            if (command.equals("end of assignment")) {
                break;
            }

            String[] commandArr = command.split("->");
            String user = commandArr[0];
            String team = commandArr[1];

            if (!Team.isTeamExist(teamList, team)) {
                System.out.printf("Team %s does not exist!%n", team);
                continue;
            }

            if (Team.isUserMemberOfTeam(teamList, user)) {
                System.out.printf("Member %s cannot join team %s!%n", user, team);
                continue;
            }

            for (Team team1 : teamList) {
                if (team1.getName().equals(team)) {
                    team1.addUser(user, team);
                    break;
                }
            }
        }

        List<Team> disbandTeams = new ArrayList<>();

        for (Team team : teamList) {
            if (team.isTeamForDisband()) {
                disbandTeams.add(team);
            }
        }

        teamList.removeAll(disbandTeams);

        for (int i = 0; i < teamList.size() - 1; i++) {
            int bestCnt = teamList.get(i).getMemberCount();
            int bestIndex = -1;

            for (int j = i + 1; j < teamList.size(); j++) {

                if (bestCnt < teamList.get(j).getMemberCount()) {
                    bestCnt = teamList.get(j).getMemberCount();
                    bestIndex = j;
                }
            }

            if (bestIndex != -1) {
                Team temp = teamList.get(i);
                teamList.set(i, teamList.get(bestIndex));
                teamList.set(bestIndex, temp);
            }
        }

        for (Team team : teamList) {
            System.out.println(team.getName());
            team.sortAndPrintMembers();
        }

        System.out.println("Teams to disband:");

        if (disbandTeams.size() != 0) {
            List<String> names = new ArrayList<>();

            for (int i = 0; i < disbandTeams.size(); i++) {
                names.add(disbandTeams.get(i).getName());
            }

            Collections.sort(names, String.CASE_INSENSITIVE_ORDER);

            for (int i = 0; i < names.size(); i++) {
                System.out.println(names.get(i));
            }
        }
    }
}
