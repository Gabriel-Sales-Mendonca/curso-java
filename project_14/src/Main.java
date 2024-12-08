import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        List<Product> products = new ArrayList<>();

        for(int product = 1; product <= n; product++) {
            System.out.printf("Product #%d data:%n", product);
            System.out.print("Common, used or imported (c/u/i)? ");

            char type = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            if(type == 'c') {
                products.add(new Product(name, price));
            }
            else if(type == 'i') {
                System.out.print("Customs fee: ");
                double customFee = sc.nextDouble();
                products.add(new ImportedProduct(name, price, customFee));
            }
            else if(type == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufactureDate = LocalDate.parse(sc.next(), format);
                products.add(new UsedProduct(name, price, manufactureDate));
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS:");
        for(Product product : products) {
            System.out.println(product.priceTag());
        }
    }
}