package customexceptions;

public class InvalidProductException extends Exception{

    public InvalidProductException () {
        super("Invalid product selection.");
    }
}
