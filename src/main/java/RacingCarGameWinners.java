import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RacingCarGameWinners {
    private final List<Car> winnersList = new ArrayList<>();

    public int updateMaxDistance(Car car, int maxDistance) {
        if (car.getMovingDistance() > maxDistance) {
            setWinner(car);
            return car.getMovingDistance();
        }

        if (car.getMovingDistance() == maxDistance) {
            addWinner(car);
        }

        return maxDistance;
    }

    private void setWinner(Car car) {
        winnersList.clear();
        winnersList.add(car);
    }

    private void addWinner(Car car) {
        winnersList.add(car);
    }

    public String getWinnersName() {
        StringBuilder winnerNames = new StringBuilder();

        Iterator<Car> iterator = winnersList.iterator();

        winnerNames.append(iterator.next());

        while (iterator.hasNext()) {
            winnerNames.append(", ")
                    .append(iterator.next());
        }

        return winnerNames.toString();
    }
}
