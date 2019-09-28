package jdbc.dao;

public class NoPersonIdException extends RuntimeException {
    public NoPersonIdException(String message) {
        super(message);
    }
}
