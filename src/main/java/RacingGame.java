import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class RacingGame {

    private final Random random = new Random(); //주사위
    private final List<Car> cars;
    private final int round;

    RacingGame(List<String> playerNames, int round) {
        cars = CarMaker.make(playerNames);
        this.round = round;
    }

    List<Car> getCars() {
        return cars;
    }

    int getRound() {
        return round;
    }

    void start() {
        IntStream.range(0, round)
            .forEach(i -> startOneRound());
    }

    private void startOneRound() {
        cars.forEach(c -> c.goOneStep(random.nextInt(10)));
    }

    List<Car> getWinner() {
        Car winner = Collections.max(cars);
        return cars.stream()
            .filter(c -> c.isWinner(winner))
            .collect(Collectors.toList());
    }
}
