import java.util.Scanner;

public class Login_5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String userName = reader.nextLine();

        String password = "";
        for (int i = userName.length() - 1; i >= 0; i--) {
            password += userName.charAt(i);
        }

        String userPass = reader.nextLine();
        int cnt = 0;
        while (!userPass.equals(password)) {
            cnt++;
            if (cnt < 4) {
                System.out.println("Incorrect password. Try again.");
                userPass = reader.nextLine();
            } else {
                System.out.printf("User %s blocked!", userName);
                break;
            }
        }

        if (userPass.equals(password)) {
            System.out.printf("User %s logged in.", userName);
        }
    }
}
