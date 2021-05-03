package customexceptions;

public class InsufficientQuantity extends Exception{
    public InsufficientQuantity() {
        super("Product is not available");
    }

}
