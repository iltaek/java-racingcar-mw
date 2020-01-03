import java.nio.charset.MalformedInputException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator {

    private final String carNamesFromUserInput;
    private final String racingCountsFromUserInput;

    // (DELIMITER 이외의 문자열)+(DELIMITER(DELIMITER 이외의 문자열))+*
    // FIXME: 정규표현식에 RacingGame_Constant.DELIMITER_FOR_CAR_NAMES 를 쓰고 싶지만, 가독성을 해친다. 일단은 현재 DELIMITER인 콤마(,)로 둔다.
    private final String carNamesRegExp = "^(((?!,).)+)(,((?!,).)+)*$";
    // 1 이상의 숫자
    private final String racingCountsRegExp = "^[1-9]([0-9]*)$";

    UserInputValidator(String carNamesFromUserInput, String racingCountsFromUserInput) {
        this.carNamesFromUserInput = carNamesFromUserInput;
        this.racingCountsFromUserInput = racingCountsFromUserInput;
    }

    public void validate() {
        try{
            validateCarNames();
            validateRacingCounts();
        }catch(MalformedUserInputException muie) {
            System.out.println(muie.getMessage());
            System.exit(-1);
        }
    }

    private void validateCarNames() throws MalformedUserInputException {
        if (carNamesFromUserInput.matches(carNamesRegExp)) {
            return;
        }
        throw new MalformedUserInputException(
            RacingGame_ExceptionMessage.EXCEPTION_MESSAGE_MALFORMED_CAR_NAMES);
    }

    private void validateRacingCounts() throws MalformedUserInputException {
        if (racingCountsFromUserInput.matches(racingCountsRegExp)) {
            return;
        }
        throw new MalformedUserInputException(
            RacingGame_ExceptionMessage.EXCEPTION_MESSAGE_MALFORMED_RACING_COUNTS);
    }
}
