import java.util.List;

public class RacingCarGame {
    private final double SUCCESS_THRESHOLD = 4;

    public void playSingleGame(List<Car> carList) {
        for (Car car : carList) {
            tryMove(car, generateRandomNumber());
        }
    }

    public int generateRandomNumber() {
        double randomNumber = Math.random() * 10;
        return (int) randomNumber;
    }

    public void tryMove(Car car, int number) {
        if (number >= SUCCESS_THRESHOLD) {
            car.move();
        }
    }
}
