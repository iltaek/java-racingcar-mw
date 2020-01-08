import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCarGameInputCheckerTest {
    @ParameterizedTest
    @Description("쉼표로 구분짓는 레이싱카 이름에 대해 공백 입력시 올바르게 에러를 처리하는지 테스트.")
    @NullAndEmptySource
    @ValueSource(strings = {"", ",", "Car_1,", ",Car_1"})
    void emptyInputForCarNamesTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingCarGameInputChecker().checkCarNames(input))
                .withMessage("자동차 이름 입력이 잘못되었습니다. 공백이 아닌 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @Description("쉼표로 구분짓는 레이싱카 이름에 대해 중복된 이름 입력시 올바르게 에러를 처리하는지 테스트.")
    @ValueSource(strings = {"Car_1,Car_1", "Car_1,Car_2,Car_1"})
    void duplicatedNameInputForCarNamesTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingCarGameInputChecker().checkCarNames(input))
                .withMessage("자동차 이름 입력이 잘못되었습니다. 중복되지 않도록 서로 다른 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @Description("자연수로 표현되는 게임 실행 횟수에 대해 공백 입력시 올바르게 에러를 처리하는지 테스트.")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void emptyInputForNumberOfExecutionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingCarGameInputChecker().checkNumberOfExecution(input))
                .withMessage("게임 실행 횟수 입력이 잘못되었습니다. 자연수 숫자를 입력해주세요.");
    }

    @ParameterizedTest
    @Description("자연수로 표현되는 게임 실행 횟수에 대해 자연수가 아닌 값 입력시 올바르게 에러를 처리하는지 테스트.")
    @ValueSource(strings = {"a", "#", ",", "/", "-3", "1 + 2", "3.14"})
    void nonNaturalNumberInputForNumberOfExecutionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingCarGameInputChecker().checkNumberOfExecution(input))
                .withMessage("게임 실행 횟수 입력이 잘못되었습니다. 자연수 숫자를 입력해주세요.");
    }
}
