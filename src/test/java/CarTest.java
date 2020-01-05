import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    final Random random = new Random();

    @Test
    @DisplayName("한 번의 round를 진행하는 테스트")
    public void goOneStepTest() {
        //given
        Car car = new Car("CarA", 4);
        //when
        car.goOneStep(random.nextInt(10));
        //then
        assertThat(car.getValues().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("두 번 이상의 round를 진행하는 테스트")
    public void goManyStepsTest() {
        //given
        Car car = new Car("CarA", 4);
        //when
        for (int i = 0; i < 5; i++) {
            car.goOneStep(random.nextInt(10));
        }
        //then
        assertThat(car.getValues().size()).isEqualTo(5);
    }

    @Test
    public void 최종_점수를_계산하는_테스트() {
        //given
        Car car = new Car("CarA", 4);

        //when
        for (int i = 0; i < 5; i++) {
            car.goOneStep(random.nextInt(10));
        }
        List<Integer> values = car.getValues();
        int score = (int) values.stream().filter(s -> s >= 4).count();

        //then
        assertThat(car.getLastScore()).isEqualTo(score);
    }

    @Test
    public void 라운드별_누적점수_계산_테스트() {
        //given
        Car car = new Car("CarA", 4);
        //when
        for (int i = 0; i < 5; i++) {
            car.goOneStep(random.nextInt(10));
        }
        List<Integer> values = car.getValues();
        //then
        int accumulatedScore = 0;
        for (int i = 0; i < 5; i++) {
            accumulatedScore += values.get(i) >= 4 ? 1 : 0;
            assertThat(car.getScores().get(i)).isEqualTo(accumulatedScore);
        }

    }

}
