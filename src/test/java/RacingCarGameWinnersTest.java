import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarGameWinnersTest {
    @Test
    @Description("���̽�ī ����� �޾� ���� ���� �̵��� ���� ����ڸ��� ���� ����Ʈ�� �ǰ� ��ȯ�ϴ��� �׽�Ʈ")
    void getWinnersTest() {
        List<Car> carList = getCarList();

        RacingCarGameWinners racingCarGameWinners = new RacingCarGameWinners();
        List<Car> actualWinners = racingCarGameWinners.getWinners(carList);

        assertEquals(2, actualWinners.size());
        assertTrue(actualWinners.contains(new Car("Car_3")));
        assertTrue(actualWinners.contains(new Car("Car_5")));
    }

    @Description("5���� ���̽�ī�� ���� List<Car>�� ��ȯ�Ѵ�. �� �� ���� ���� �̵��� ���� ����ڴ� 'Car_3', 'Car_5'�� �� ���̴�.")
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
