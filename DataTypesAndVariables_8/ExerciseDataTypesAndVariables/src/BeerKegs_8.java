import java.util.Scanner;

public class BeerKegs_8 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int kegsCnt = Integer.parseInt(reader.nextLine());

        double maxVolume = Double.MIN_VALUE;
        String biggestModel = "";

        for (int i = 0; i < kegsCnt; i++) {
            String modelKeg = reader.nextLine();
            double radius = Double.parseDouble(reader.nextLine());
            int height = Integer.parseInt(reader.nextLine());

            double currentVolume = Math.PI * radius * radius * height;

            if (currentVolume > maxVolume) {
                maxVolume = currentVolume;
                biggestModel = modelKeg;
            }
        }

        System.out.println(biggestModel);
    }
}
