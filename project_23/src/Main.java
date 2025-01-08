import entities.People;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.next();

        List<People> peoples = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String name = line.split(",")[0];
                String email = line.split(",")[1];
                Double salary = Double.parseDouble(line.split(",")[2]);

                peoples.add(new People(name, email, salary));
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo");
        }

        System.out.print("Enter salary: ");
        Double salary = sc.nextDouble();
        sc.nextLine();

        List<String> emails = peoples.stream()
                        .filter(p -> p.getSalary() > salary)
                        .map(People::getEmail)
                        .sorted()
                        .toList();

        System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
        emails.forEach(System.out::println);

        double sum = peoples.stream()
                .filter(p -> p.getName().toUpperCase().charAt(0) == 'M')
                .map(p -> p.getSalary())
                .reduce(0.0, (salary1, salary2) -> salary1 + salary2);

        System.out.println("Sum of salary from people whose name starts with 'M': " + String.format("%.2f", sum));

        sc.close();
    }
}