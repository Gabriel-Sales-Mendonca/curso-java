import employee.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Employee> listEmployee = new ArrayList<>();
        for(int c = 0; c < n; c++) {
            System.out.printf("Employee #%d:%n", c + 1);

            System.out.print("Id: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Name: ");
            String name = sc.nextLine();

            System.out.println("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            Employee employee = new Employee(id, name, salary);
            listEmployee.add(employee);
        }

        System.out.print("Enter the employee id that will have salary increase : ");
        int idEmployee = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the percentage: ");
        double percentage = sc.nextDouble();
        sc.nextLine();

        for(Employee employee : listEmployee) {
            if(employee.getId() == idEmployee) {
                employee.increaseSalary(percentage);
            }
        }

        System.out.println("List of employees:");

        for(Employee employee : listEmployee) {
            System.out.println(employee.getId() + ", " + employee.getName() + ", " + employee.getSalary());
        }
    }
}