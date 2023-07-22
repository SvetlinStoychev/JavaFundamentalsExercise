import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_2_2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        String regexBarcode = "@#+(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        String regexDigit = "\\d";
        Pattern pattern;
        Matcher matcher;
        for (int i = 0; i < n; i++) {
            String barcode = reader.nextLine();
            pattern = Pattern.compile(regexBarcode);
            matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                String currentBarcode = matcher.group("barcode");
                pattern = Pattern.compile(regexDigit);
                matcher = pattern.matcher(currentBarcode);
                StringBuilder groupSb = new StringBuilder();

                while (matcher.find()) {
                    groupSb.append(matcher.group());
                }

                if (groupSb.length() == 0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + groupSb);
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
