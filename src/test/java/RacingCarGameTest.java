import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarGameTest {

    @Test
    @Description("0 ���� 9 ������ ���� ���ڸ� �����ϴ��� �׽�Ʈ")
    void generateRandomNumberTest() {
        RacingCarGame racingCarGame = new RacingCarGame();
        int randomNumber = racingCarGame.generateRandomNumber();

        assertTrue(randomNumber >= 0);
        assertTrue(randomNumber < 10);
    }

    @ParameterizedTest
    @Description("�� �� �뿡 ���ؼ� ���� ���� 4 �̸��� �� ���� �������� �ʴ��� �׽�Ʈ")
    @ValueSource(ints = {0, 1, 2, 3})
    void singleCarNotMoveTest(int number) {
        RacingCarGame racingCarGame = new RacingCarGame();
        Car car = new Car("Car_1");
        racingCarGame.tryMove(car, number);

        assertEquals(0, car.getMovingDistance());
    }

    @ParameterizedTest
    @Description("�� �� �뿡 ���ؼ� ���� ���� 4 �̻��� �� ���� �����̴��� �׽�Ʈ")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void singleCarMoveTest(int number) {
        RacingCarGame racingCarGame = new RacingCarGame();
        Car car = new Car("Car_1");
        racingCarGame.tryMove(car, number);

        assertEquals(1, car.getMovingDistance());
    }

    @Test
    @Description("�� ���� �뿡 ���ؼ� ������ �� �� �ϴ� �׽�Ʈ")
    void multiCarRacingGameTest() {
        RacingCarGame racingCarGame = new RacingCarGame();

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Car_1"));
        carList.add(new Car("Car_2"));
        carList.add(new Car("Car_3"));

        racingCarGame.playSingleGame(carList);

        for (Car car : carList) {
            assertTrue(car.getMovingDistance() == 0 || car.getMovingDistance() == 1);
        }
    }
}
