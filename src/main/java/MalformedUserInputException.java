import java.io.IOException;

public class MalformedUserInputException extends IOException {

    public MalformedUserInputException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
