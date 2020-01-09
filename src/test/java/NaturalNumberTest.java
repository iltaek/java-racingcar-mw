import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NaturalNumberTest {

    @ParameterizedTest
    @CsvSource({"0", "-1"})
    void InvalidInputTest(int in) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new NaturalNumber(in))
                .withMessageContaining("입력된 값이 자연수가 아닙니다.");
    }
}