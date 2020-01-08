import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarGameResultTest {
    /**
     *  < 의도한 출력 결과 >
     *
     *  실행 결과 :
     *  Car_1 :
     *  Car_2 : -
     *  Car_3 : --
     *  (공백)
     *  (공백)
     */
    @Test
    @Description("레이싱카 목록을 받아 중간 진행 상태를 그림으로 옳게 표현해주는지 테스트")
    void intermediateResultTest() {
        String expectedResult = "실행 결과 : " +
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

    @Description("3대의 레이싱카를 담은 List<Car>를 반환한다. 이 때 n번 차는 n-1 만큼 이동한 상태라고 설정한다.")
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
     *  < 의도한 출력 결과 >
     *
     *  실행 결과 :
     *  Car_4, Car_5이(가) 최종 우승 했습니다.
     */
    @Test
    @Description("레이싱카 최종 우승자 목록을 받아 최종 진행 결과를 옳게 알려주는지 테스트.")
    void finalResultTest() {
        String expectedResult = "실행 결과 : " +
                "\n" +
                "Car_4, Car_5" +
                "이(가) 최종 우승 했습니다.";

        List<Car> winnersList = new ArrayList<>();
        winnersList.add(new Car("Car_4"));
        winnersList.add(new Car("Car_5"));

        RacingCarGameResult racingCarGameResult = new RacingCarGameResult();
        racingCarGameResult.prepareFinalResult(winnersList);
        String actualResult = racingCarGameResult.getResult();

        assertEquals(expectedResult, actualResult);
    }

    /**
     *  < 의도한 출력 결과 >
     *
     *  실행 결과 :
     *  Car_1 :
     *  Car_2 : -
     *  Car_3 : --
     *
     *  Car_1 : -
     *  Car_2 : --
     *  Car_3 : ---
     *
     *  Car_3이(가) 최종 우승 했습니다.
     */
    @Test
    @Description("레이싱카 게임을 두 번 진행한 상황을 가정하여 전체 결과가 옳게 표현되는지 테스트.")
    void playGameTwiceResultTest() {
        String expectedResult = "실행 결과 : " +
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
                "이(가) 최종 우승 했습니다.";

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
