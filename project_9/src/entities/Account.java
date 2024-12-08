package entities;

import exceptions.BalanceZeroException;

public class Account {
    private final Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    //inicio get e set
    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
    //fim get e set

    public Account(Integer number, String holder, Double initialBalance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = initialBalance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) throws BalanceZeroException {
        if(balance <= 0) {
            throw new BalanceZeroException("O balanço da conta é zero.");
        }
        if(amount > withdrawLimit) {
            throw new BalanceZeroException("O valor do saque é maior que o limite de saque");
        }

        balance -= amount;
    }
}
