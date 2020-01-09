import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    @Test
    void moveOnceTest() {
        Race aGame = new Race(new String[]{"pobi", "crong", "honux"}, new NaturalNumber(1));
        aGame.moveOnce();
        for (Car aCar : aGame.getCars()) {
            assertTrue(aCar.getLocation() == 0 || aCar.getLocation() == 1);
        }
    }

    @ParameterizedTest
    @CsvSource({"pobi,crong,honux", "5"})
    void raceTest(String names, int num) {
        Race aGame = new Race(names.split(","), new NaturalNumber(num));
        aGame.start();
        List<Car> winner = aGame.getWinner();
        assertTrue(winner != null && !winner.isEmpty());
    }

    @Test
    void invalidInputTest() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Race(null, null))
                .withMessageContaining("하나 이상의 자동차를 입력해 주세요.");
    }
}