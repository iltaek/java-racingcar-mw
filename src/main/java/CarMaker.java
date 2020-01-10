import java.util.List;
import java.util.stream.Collectors;

public class CarMaker {

    private static final Integer CRITERION = 4; //기준 점수 이상일 경우 전진, 미만이면 정지

    public static List<Car> make(List<String> playerNames) {
        return playerNames.stream().map(CarMaker::make).collect(Collectors.toList());
    }

    public static Car make(String playerName) {
        return new Car(playerName, CRITERION);
    }
}
