package throwable;

public class InvalidInstructionException extends Exception{
    public InvalidInstructionException(String errorMessage) {
        super(errorMessage);
    }
}
