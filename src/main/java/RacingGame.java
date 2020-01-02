import java.util.Collections;
import java.util.List;


public class RacingGame {

    final List<Car> cars;
    final int round;

    public RacingGame(List<String> carNames, int round) {
        this.cars = CarMaker.makeCars(carNames);
        this.round = round;
    }

    public List<Car> start() {

        for (int i = 0; i < round; i++) {
            raceEachRound(cars);
        }

        findWinner(cars);

        return cars;

    }

    private void raceEachRound(List<Car> cars) {
        cars.forEach(Car::go);
    }

    private void findWinner(List<Car> cars) {

        Car winner = Collections.max(cars);

        for (Car car : cars) {
            if (car.compareTo(winner) == 0) {
                car.setWinner();
            }
        }
    }
}
