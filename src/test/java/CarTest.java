import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.Test;

public class CarTest {

    private final Random random = new Random();

    @Test
    public void 플레이어_점수_비교_테스트() {
        //given
        Car carA = new Car("CarA", 4);
        Car carB = new Car("CarB", 4);
        //when
        for (int i = 0; i < 5; i++) {
            carA.goOneStep(random.nextInt(10));
            carB.goOneStep(random.nextInt(10));
        }
        int carAScore = carA.getLastScore();
        int carBScore = carB.getLastScore();
        //then
        assertThat(carAScore > carBScore).isEqualTo(carA.compareTo(carB) > 0);

    }

}
