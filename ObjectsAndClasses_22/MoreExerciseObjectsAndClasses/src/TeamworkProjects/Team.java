package TeamworkProjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    List<User> userList = new ArrayList<>();
    public Team(String user, String team) {
        this.userList.add(new User(user, team));
        this.name = team;
    }

    public String getName() {
        return this.name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public String getCreator() {
        return this.userList.get(0).getName();
    }
    public static boolean isTeamExist(List<Team> teamList, String teamName) {
        for (Team team : teamList) {
            if (team.getName().equals(teamName)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isUserMemberOfTeam(List<Team> teamList, String userName) {
        for (Team team : teamList) {
            if (User.isUserExist(team.getUserList(), userName)) {
                return true;
            }
        }
        return false;
    }
    public void addUser(String name, String team) {
        this.userList.add(new User(name, team));
    }
    public boolean isTeamForDisband() {
        if (this.userList.size() == 1) {
            return true;
        } else {
            return false;
        }
    }
    public int getMemberCount() {
        return this.userList.size();
    }

    public void sortAndPrintMembers() {
        List<String> names = new ArrayList<>();

        System.out.printf("- %s%n", userList.get(0).getName());
        userList.remove(0);

        for (User user : userList) {
            names.add(user.getName());
        }

        Collections.sort(names, String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < names.size(); i++) {

            System.out.printf("-- %s%n", names.get(i));
        }
    }
}
