package customexceptions;

public class InvalidBillException extends Exception {

    public InvalidBillException(){
        super("Invalid bill. Please insert either a 1, 2, 5, or 10 bill");
    }

}
