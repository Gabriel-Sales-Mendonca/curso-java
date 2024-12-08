import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Gross Salary: ");
        double salary = sc.nextDouble();

        System.out.print("Tax: ");
        double tax = sc.nextDouble();

        Employee employee = new Employee();
        employee.name = name;
        employee.grossSalary = salary;
        employee.tax = tax;

        System.out.println("Employee: " + employee);

        System.out.println("Which  percentage to increase salary? ");
        double percentage = sc.nextDouble();

        employee.increaseSalary(percentage);

        System.out.printf("Update data: %s", employee);

        sc.close();
    }
}