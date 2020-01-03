import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputTest {

    @ParameterizedTest
    @DisplayName("입력값분리개수체크")
    @Description("입력값을 DELIMITER를 통해 분리하였을 때, 값들의 갯수들을 체크한다.")
    @CsvSource(value = {"A,B,C;3", "AB,CD;2"}, delimiter = ';')
    void testSplitedUserInputCounting(String input, int expected) {
        String[] splitedInput = input.split(",");
        int carCount = splitedInput.length;
        assertEquals(expected,carCount);
    }

    @ParameterizedTest
    @DisplayName("입력값없음체크")
    @Description("입력값이 없을 때, Exception을 발생시키는지 체크한다.")
    @ValueSource(strings = {"A,B", "C", ""})
    void Should_ExitWithMessage_When_EmptyInputComes(String input){

    }
}
