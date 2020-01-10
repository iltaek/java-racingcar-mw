package racing.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racing.domain.movingstrategy.RandomMoveStrategy;

public class RacingGame {

    private List<Car> cars;
    private int tries;

    public RacingGame(List<String> names, int tries) {
        this.cars = createCars(names);
        this.tries = tries;
    }

    public void doRaces() {
        IntStream.range(0, tries)
            .forEach(i -> doRace());
    }

    private void doRace() {
        cars.forEach(Car::move);
    }

    protected List<Car> createCars(List<String> namesOfCars) {
        namesOfCars.forEach(name -> cars.add(new Car(new RandomMoveStrategy(), name)));
        return cars;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public int getTries() {
        return tries;
    }

    public List<String> getWinnerNames() {
        int biggestPosition = getBiggestPosition();
        return cars.stream()
            .filter(car -> car.isPositioned(biggestPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int getBiggestPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();
    }

    public Map<String, Queue<Integer>> getResults() {
        Map<String, Queue<Integer>> results = new HashMap<>();
        cars.forEach(car -> results.put(car.getName(), car.getRecords()));
        return results;
    }
}
