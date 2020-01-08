import java.util.HashSet;
import java.util.Set;

public class RacingCarGameInputChecker {
    private static final String CAR_NAMES_LENGTH_INPUT_ERROR = "자동차 이름 입력이 잘못되었습니다. 공백이 아닌 이름을 입력해주세요.";
    private static final String CAR_NAMES_DUPLICATION_INPUT_ERROR = "자동차 이름 입력이 잘못되었습니다. 중복되지 않도록 서로 다른 이름을 입력해주세요.";
    private static final String NUMBER_OF_EXECUTION_INPUT_ERROR = "게임 실행 횟수 입력이 잘못되었습니다. 자연수 숫자를 입력해주세요.";


    public void checkCarNames(String carNames) {
        checkIfEmpty(carNames);

        Set<String> carNamesSet = new HashSet<>();

        for (String carName : carNames.split(",")) {
            validateLength(carName);
            validateDuplication(carName, carNamesSet);
        }
    }

    private void checkIfEmpty(String carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException(CAR_NAMES_LENGTH_INPUT_ERROR);
        }

        if (carNames.length() == 0) {
            throw new IllegalArgumentException(CAR_NAMES_LENGTH_INPUT_ERROR);
        }

        if (carNames.endsWith(",")) {
            throw new IllegalArgumentException(CAR_NAMES_LENGTH_INPUT_ERROR);
        }

        String[] carNamesArray = carNames.split(",");
        if (carNamesArray.length == 0) {
            throw new IllegalArgumentException(CAR_NAMES_LENGTH_INPUT_ERROR);
        }
    }

    private void validateLength(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException(CAR_NAMES_LENGTH_INPUT_ERROR);
        }
    }

    private void validateDuplication(String name, Set<String> carNamesSet) {
        if (carNamesSet.contains(name)) {
            throw new IllegalArgumentException(CAR_NAMES_DUPLICATION_INPUT_ERROR);
        }

        carNamesSet.add(name);
    }

    public void checkNumberOfExecution(String numberOfExecution) {
        int integerNumber = checkAndReturnIfIntegerNumber(numberOfExecution);
        checkIfNaturalNumber(integerNumber);
    }

    private int checkAndReturnIfIntegerNumber(String numberOfExecution) {
        try {
            return Integer.parseInt(numberOfExecution);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_OF_EXECUTION_INPUT_ERROR);
        }
    }

    private void checkIfNaturalNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException(NUMBER_OF_EXECUTION_INPUT_ERROR);
        }
    }
}
