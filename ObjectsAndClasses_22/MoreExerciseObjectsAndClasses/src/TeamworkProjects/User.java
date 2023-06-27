package TeamworkProjects;

import java.util.List;

public class User {
    private String name;
    private String team;

    public User(String name, String team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return this.name;
    }
    public static boolean isUserExist(List<User> userList, String userName) {
        for (User user : userList) {
            if (user.getName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
}
