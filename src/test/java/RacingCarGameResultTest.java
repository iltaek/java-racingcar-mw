import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarGameResultTest {
    /**
     *  < �ǵ��� ��� ��� >
     *
     *  ���� ��� :
     *  Car_1 :
     *  Car_2 : -
     *  Car_3 : --
     *  (����)
     *  (����)
     */
    @Test
    @Description("���̽�ī ����� �޾� �߰� ���� ���¸� �׸����� �ǰ� ǥ�����ִ��� �׽�Ʈ")
    void intermediateResultTest() {
        String expectedResult = "���� ��� : " +
                "\n" +
                "Car_1 : " +
                "\n" +
                "Car_2 : -" +
                "\n" +
                "Car_3 : --" +
                "\n" +
                "\n";

        List<Car> carList = getCarList();

        RacingCarGameResult racingCarGameResult = new RacingCarGameResult();
        racingCarGameResult.prepareIntermediateResult(carList);
        String actualResult = racingCarGameResult.getResult();

        assertEquals(expectedResult, actualResult);
    }

    @Description("3���� ���̽�ī�� ���� List<Car>�� ��ȯ�Ѵ�. �� �� n�� ���� n-1 ��ŭ �̵��� ���¶�� �����Ѵ�.")
    private List<Car> getCarList() {
        Car car1 = new Car("Car_1");

        Car car2 = new Car("Car_2");
        car2.move();

        Car car3 = new Car("Car_3");
        car3.move();
        car3.move();

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        return carList;
    }

    /**
     *  < �ǵ��� ��� ��� >
     *
     *  ���� ��� :
     *  Car_4, Car_5��(��) ���� ��� �߽��ϴ�.
     */
    @Test
    @Description("���̽�ī ���� ����� ����� �޾� ���� ���� ����� �ǰ� �˷��ִ��� �׽�Ʈ.")
    void finalResultTest() {
        String expectedResult = "���� ��� : " +
                "\n" +
                "Car_4, Car_5" +
                "��(��) ���� ��� �߽��ϴ�.";

        List<Car> winnersList = new ArrayList<>();
        winnersList.add(new Car("Car_4"));
        winnersList.add(new Car("Car_5"));

        RacingCarGameResult racingCarGameResult = new RacingCarGameResult();
        racingCarGameResult.prepareFinalResult(winnersList);
        String actualResult = racingCarGameResult.getResult();

        assertEquals(expectedResult, actualResult);
    }

    /**
     *  < �ǵ��� ��� ��� >
     *
     *  ���� ��� :
     *  Car_1 :
     *  Car_2 : -
     *  Car_3 : --
     *
     *  Car_1 : -
     *  Car_2 : --
     *  Car_3 : ---
     *
     *  Car_3��(��) ���� ��� �߽��ϴ�.
     */
    @Test
    @Description("���̽�ī ������ �� �� ������ ��Ȳ�� �����Ͽ� ��ü ����� �ǰ� ǥ���Ǵ��� �׽�Ʈ.")
    void playGameTwiceResultTest() {
        String expectedResult = "���� ��� : " +
                "\n" +
                "Car_1 : " +
                "\n" +
                "Car_2 : -" +
                "\n" +
                "Car_3 : --" +
                "\n" +
                "\n" +
                "Car_1 : -" +
                "\n" +
                "Car_2 : --" +
                "\n" +
                "Car_3 : ---" +
                "\n" +
                "\n" +
                "Car_3" +
                "��(��) ���� ��� �߽��ϴ�.";

        List<Car> carList = getCarList();

        RacingCarGameResult racingCarGameResult = new RacingCarGameResult();
        racingCarGameResult.prepareIntermediateResult(carList);

        for (Car car : carList) {
            car.move();
        }

        racingCarGameResult.prepareIntermediateResult(carList);

        List<Car> winnersList = new ArrayList<>();
        winnersList.add(new Car("Car_3"));

        racingCarGameResult.prepareFinalResult(winnersList);

        String actualResult = racingCarGameResult.getResult();

        assertEquals(expectedResult, actualResult);
    }
}
