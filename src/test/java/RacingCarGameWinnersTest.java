import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarGameWinnersTest {
    @Test
    @Description("레이싱카 목록을 받아 가장 많이 이동한 최종 우승자만을 담은 리스트를 옳게 반환하는지 테스트")
    void getWinnersTest() {
        List<Car> carList = getCarList();

        RacingCarGameWinners racingCarGameWinners = new RacingCarGameWinners();
        List<Car> actualWinners = racingCarGameWinners.getWinners(carList);

        assertEquals(2, actualWinners.size());
        assertTrue(actualWinners.contains(new Car("Car_3")));
        assertTrue(actualWinners.contains(new Car("Car_5")));
    }

    @Description("5대의 레이싱카를 담은 List<Car>를 반환한다. 이 중 가장 많이 이동한 최종 우승자는 'Car_3', 'Car_5'가 될 것이다.")
    private List<Car> getCarList() {
        Car car1 = new Car("Car_1");
        car1.move();
        car1.move();

        Car car2 = new Car("Car_2");
        car2.move();

        Car car3 = new Car("Car_3");
        car3.move();
        car3.move();
        car3.move();

        Car car4 = new Car("Car_4");
        car4.move();
        car4.move();

        Car car5 = new Car("Car_5");
        car5.move();
        car5.move();
        car5.move();

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);

        return carList;
    }
}
