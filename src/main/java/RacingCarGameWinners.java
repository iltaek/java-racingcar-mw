import java.util.ArrayList;
import java.util.List;

public class RacingCarGameWinners {
    private final List<Car> winnersList = new ArrayList<>();
    private int winnersMovingDistance;

    public List<Car> getWinners(List<Car> carList) {
        for (Car car : carList) {
            checkIfWinner(car);
        }

        return winnersList;
    }

    public void checkIfWinner(Car car) {
        if (car.getMovingDistance() > winnersMovingDistance) {
            winnersMovingDistance = car.getMovingDistance();
            setWinner(car);
            return;
        }

        if (car.getMovingDistance() == winnersMovingDistance) {
            addWinner(car);
        }
    }

    private void setWinner(Car car) {
        winnersList.clear();
        winnersList.add(car);
    }

    private void addWinner(Car car) {
        winnersList.add(car);
    }
}
