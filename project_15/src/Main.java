import entities.Person;
import entities.PersonLegal;
import entities.PersonPhysics;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for(int person = 1; person <= n; person++) {
            System.out.printf("Tax payer #%d data:%n", person);
            System.out.print("Individual or company (i/c)? ");
            char response = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double incomeAnual = sc.nextDouble();

            if(response == 'i') {
                System.out.print("Health expenditures: ");
                double spentWithHealth = sc.nextDouble();
                persons.add(new PersonPhysics(name, incomeAnual, spentWithHealth));
            }
            else if(response == 'c') {
                System.out.print("Number of employees: ");
                int numberEmployees = sc.nextInt();
                persons.add(new PersonLegal(name, incomeAnual, numberEmployees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        double sum = 0.0;
        for(Person eachPerson : persons) {
            System.out.println(eachPerson);
            sum += eachPerson.tax();
        }

        System.out.printf("TOTAL TAXES: $ %.2f", sum);

        sc.close();
    }
}