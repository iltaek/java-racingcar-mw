import java.util.ArrayList;
import java.util.List;

public class RacingCarGameMain {
    public static void main(String[] args) {
        RacingCarGameInputReceiver racingCarGameInputReceiver = new RacingCarGameInputReceiver();

        String carNames = racingCarGameInputReceiver.getCarNames();
        while (!isValidCarNames(carNames)) {
            carNames = racingCarGameInputReceiver.getCarNames();
        }
        List<Car> carList = getCarList(carNames);

        String numberOfExecution = racingCarGameInputReceiver.getNumberOfExecution();
        while (!isValidNumberOfExecution(numberOfExecution)) {
            numberOfExecution = racingCarGameInputReceiver.getNumberOfExecution();
        }
        int number = Integer.parseInt(numberOfExecution);

        new RacingCarGameLauncher().launch(carList, number);
    }

    private static boolean isValidCarNames(String carNames) {
        try {
            new RacingCarGameInputChecker().checkCarNames(carNames);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static boolean isValidNumberOfExecution(String numberOfExecution) {
        try {
            new RacingCarGameInputChecker().checkNumberOfExecution(numberOfExecution);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static List<Car> getCarList(String carNames) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames.split(",")) {
            carList.add(new Car(carName));
        }

        return carList;
    }
}
