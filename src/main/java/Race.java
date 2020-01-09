import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Race {
    private List<Car> cars;
    private final NaturalNumber tryNum;

    Race(String[] carsName, NaturalNumber tryNum) {
        if (carsName == null || carsName.length == 0) {
            throw new IllegalArgumentException("하나 이상의 자동차를 입력해 주세요.");
        }
        this.cars = new ArrayList<Car>();
        for (String name : carsName) {
            addCar(new Car(name));
        }
        this.cars = Collections.unmodifiableList(cars);
        this.tryNum = tryNum;
    }

    void start() {
        ResultView resultView = new ResultView();
        resultView.printTitle();
        for (int i=0; i<tryNum.intValue(); i++) {
            moveOnce();
            resultView.printLocation(cars);
        }
        resultView.printWinner(getWinner());
    }

    List<Car> getWinner() {
        int longest = getCars().stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(-1);

        return getCars().stream()
                .filter(c -> c.getLocation() == longest)
                .collect(toList());
    }

    void addCar(Car newCar) {
        cars.add(newCar);
    }

    void moveOnce() {
        cars.forEach(Car::move);
    }

    List<Car> getCars() {
        return cars;
    }
}
