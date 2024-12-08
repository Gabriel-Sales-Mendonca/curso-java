package exceptions;

public class BalanceZeroException extends Exception {
    public BalanceZeroException(String msg) {
        super(msg);
    }
}
