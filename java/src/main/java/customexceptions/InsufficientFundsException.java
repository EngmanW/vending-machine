package customexceptions;

public class InsufficientFundsException extends Exception{

    public InsufficientFundsException() {
        super("Insufficient funds. Please add money.");
    }
}
