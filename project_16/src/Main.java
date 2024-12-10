import entities.Product;

import java.io.*;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o caminho do arquivo: ");
        String path = sc.nextLine();

        List<Product> listProducts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while(line != null) {
                String[] datas = line.split(",");
                String name = datas[0];
                double price = Double.parseDouble(datas[1]);
                int amount = Integer.parseInt(datas[2]);

                Product product = new Product(name, price, amount);
                listProducts.add(product);

                line = br.readLine();
            }
        }
        catch (IOException e) {
            System.out.println("Houve um erro " + e);
        }

        String pathSummary = "C:\\Users\\gabri\\Documents\\Gabriel\\Repositorios\\MeusProjetos\\curso-java\\project_16\\src\\files\\out";
        boolean success = new File(pathSummary).mkdir();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathSummary + "\\summary.csv"))) {
            for(Product product : listProducts) {
                bw.write(product.getName());
                bw.write("," + String.format("%.2f", product.totalValue()));
                bw.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Houve um erro: " + e);
        }

    }
}