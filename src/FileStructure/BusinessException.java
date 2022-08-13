package FileStructure;

/**
 * class that represents the business errors of the application
 */
public class BusinessException extends Exception {
    /**
     * constructor
     * @param message message associated to the current exception
     */
    public BusinessException(String message){
        super(message);
    }
}
