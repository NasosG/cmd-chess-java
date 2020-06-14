package project2;

/**
 *
 * @author Gthanasis
 */
public class InvalidMoveException extends RuntimeException {

    public InvalidMoveException() {
    }

    public InvalidMoveException(String msg) {
        super(msg);
    }
    
    @Override
    public String getMessage()
    {
        return super.getMessage();
    }
}
