import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameLauncherTest {
    @Test
    @Description("다섯 대의 레이싱카로 5회 게임을 진행하여 출력 결과물을 직접 확인할 수 있는 테스트.")
    void launchTest() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Car_1"));
        carList.add(new Car("Car_2"));
        carList.add(new Car("Car_3"));
        carList.add(new Car("Car_4"));
        carList.add(new Car("Car_5"));

        RacingCarGameLauncher racingCarGameLauncher = new RacingCarGameLauncher();
        racingCarGameLauncher.launch(carList, 5);
    }
}
