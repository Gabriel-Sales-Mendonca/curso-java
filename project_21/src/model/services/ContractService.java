package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public static void processContract(Contract contract, Integer months) {
        Double basicValue = contract.getTotalValue() / months;

        for(int numberMonth = 1; numberMonth <= months; numberMonth++) {
            LocalDate dueDate = contract.getDate().plusMonths(numberMonth);

            OnlinePaymentService service = new PaypalService();

            Double interest = service.interest(basicValue, numberMonth);
            Double fee = service.paymentFee(basicValue + interest);

            Double totalValue = basicValue + interest + fee;

            Installment installment = new Installment(dueDate, totalValue);
            contract.getInstallments().add(installment);
        }
    }
}
