import conta.ContaBancaria;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        sc.useLocale(Locale.US); //para garantir que funcione em todas as maquinas

        ContaBancaria conta;

        System.out.print("Enter account number: ");
        int numConta = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter account holder: ");
        String nomeTitular = sc.nextLine();

        System.out.print("Is there na initial deposit (y/n)? ");
        char initialDeposit = sc.next().charAt(0);

        if(initialDeposit == 'y') {
            System.out.print("Enter initial deposit value: ");
            double saldoInicial = sc.nextDouble();
            conta = new ContaBancaria(numConta, nomeTitular, saldoInicial);
        } else conta = new ContaBancaria(numConta, nomeTitular);

        System.out.println("Account data:");
        System.out.println(conta);

        System.out.print("Enter a deposit value: ");
        double deposito = sc.nextDouble();
        conta.deposito(deposito);

        System.out.println("Updated account data:");
        System.out.println(conta);

        System.out.print("Enter a withdraw value: ");
        double saque = sc.nextDouble();
        conta.saque(saque);

        System.out.println("Updated account data:");
        System.out.println(conta);

        sc.close();
    }
}