import entities.Account;
import exceptions.BalanceZeroException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        sc.next();

        System.out.print("Holder: ");
        String holder = sc.nextLine();

        System.out.print("Initial balance: ");
        Double initialBalance = sc.nextDouble();
        sc.next();

        System.out.print("Withdraw limit: ");
        Double withdrawLimit = sc.nextDouble();
        sc.next();

        try {
            Account account = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            Double withdraw = sc.nextDouble();

            account.withdraw(withdraw);

            System.out.println("New balance: " + account.getBalance());
        } catch(BalanceZeroException e) {
            System.out.println("Houve um erro: " + e);
        }
    }
}