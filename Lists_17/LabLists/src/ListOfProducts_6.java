import java.util.*;

public class ListOfProducts_6 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = Integer.parseInt(reader.nextLine());
        List<String> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String currentProduct = reader.nextLine();
            products.add(currentProduct);
        }

        Collections.sort(products);

        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, products.get(i));
        }
    }
}
