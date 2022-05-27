package exceptions;

public class CategoryException extends RuntimeException {

    public CategoryException(String message) {
        this(message, null);
    }

    public CategoryException(String message, Throwable throwable) {
        super(message, throwable);
    }

}