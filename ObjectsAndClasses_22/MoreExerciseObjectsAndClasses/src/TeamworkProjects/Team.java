package TeamworkProjects;

import java.util.ArrayList;
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
    public String getCreator() {
        return this.userList.get(0).getName();
    }
}
