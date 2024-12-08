package conta;

public class ContaBancaria {
    private final int numConta;
    private String nomeTitular;
    private double saldo;

    public ContaBancaria(int numConta, String nomeTitular, double saldoInicial) {
        this.numConta = numConta;
        this.nomeTitular = nomeTitular;
        deposito(saldoInicial);
    }

    public ContaBancaria(int numConta, String nomeTitular) {
        this.numConta = numConta;
        this.nomeTitular = nomeTitular;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public String getNomeTitular() {
        return this.nomeTitular;
    }

    public void setNomeTitular(String novoNome) {
        this.nomeTitular = novoNome;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void deposito(double deposito) {
        saldo += deposito;
    }

    public void saque(double saque) {
        saldo -= saque + 5;
    }

    public String toString() {
        return String.format("Account %d, Holder: %s, Balance: $ %.2f", numConta, nomeTitular, saldo);
    }
}
