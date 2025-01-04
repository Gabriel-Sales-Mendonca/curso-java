import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre o dados do contrato: ");
        System.out.print("Number: ");
        Integer contractNumber = sc.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        String contractDateString = sc.next();
        LocalDate contractDate = LocalDate.parse(contractDateString, formatter);

        System.out.print("Valor do contrato: ");
        Double contractTotalValue = sc.nextDouble();

        Contract contract = new Contract(contractNumber, contractDate, contractTotalValue);

        System.out.print("Entre com o número de parcelas: ");
        Integer installments = sc.nextInt();

        ContractService.processContract(contract, installments);

        System.out.println("Parcelas:");
        for(Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }

        sc.close();
    }
}