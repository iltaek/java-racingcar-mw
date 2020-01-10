import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameLauncherTest {
    @Test
    @Description("�ټ� ���� ���̽�ī�� 5ȸ ������ �����Ͽ� ��� ������� ���� Ȯ���� �� �ִ� �׽�Ʈ.")
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
