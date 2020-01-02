import java.util.List;

public class GameController {
    Car[] cars;
    private int tryNum;

    public GameController(Input input) {

    }

    public void start() {
        CarsLocation carsLocation = new CarsLocation(cars);
        for (int i=0; i<tryNum; i++) {
            carsLocation = playOnce(carsLocation);
            ResultView.viewIntermediate(carsLocation);
        }
    }

    private CarsLocation playOnce(CarsLocation carsLocation) {
        return null;
    }
}
