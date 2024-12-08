import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> listOfEmployee = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for(int c = 0, i = 1; c < n; c++, i++) {
            System.out.printf("Employee #%d data:%n", i);
            System.out.print("Outsourced (y/n)? ");
            char response = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Hours: ");
            Integer hours = sc.nextInt();

            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();

            if(response == 'n') {
                Employee employee = new Employee(name, hours, valuePerHour);
                listOfEmployee.add(employee);
            } else if(response == 'y') {
                System.out.print("Additional charge: ");
                Double additionalCharge = sc.nextDouble();

                Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                listOfEmployee.add(employee);
            }
        }

        System.out.println();
        System.out.println("PAYMENTS:");
        for(Employee eachEmployee : listOfEmployee) {
            System.out.println( eachEmployee.getName() + " - $ " +
                    String.format("%.2f", eachEmployee.payment()));
        }
        sc.close();
    }
}