import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());

        String regex = "@#+(?<code>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        for (int i = 0; i < n; i++) {
            String barcode = reader.nextLine();
            matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                String digitRegex = "\\d";
                Pattern digitPattern = Pattern.compile(digitRegex);
                Matcher digitMatcher = digitPattern.matcher(barcode);

                if (digitMatcher.find()) {
                    digitMatcher.reset();
                    StringBuilder productGroupSb = new StringBuilder();

                    while (digitMatcher.find()) {
                        productGroupSb.append(digitMatcher.group());
                    }

                    System.out.println("Product group: " + productGroupSb);
                } else {
                    System.out.println("Product group: 00");
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
