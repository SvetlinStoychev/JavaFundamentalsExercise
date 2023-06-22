import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs_4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int numSongs = Integer.parseInt(reader.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numSongs; i++) {
            String[] data = reader.nextLine().split("_");

            String typeList = data[0];
            String name = data[1];
            String time = data[2];

            Song currentSong = new Song();

            currentSong.setTypeList(typeList);
            currentSong.setName(name);
            currentSong.setTime(time);

            songs.add(currentSong);
        }

        String typeList = reader.nextLine();

        if (typeList.equals("all")) {

            for (int i = 0; i < songs.size(); i++) {
                System.out.println(songs.get(i).getName());
            }
        } else {

            for (int i = 0; i < songs.size(); i++) {

                if (songs.get(i).getTypeList().equals(typeList)) {
                    System.out.println(songs.get(i).getName());
                }
            }
        }
    }
}




