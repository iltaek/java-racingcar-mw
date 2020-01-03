import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class RacingManager {

    public static List<RacingCar> racingCarList = new ArrayList<RacingCar>();
    public static int racingRound;

    public void setRacingInformation(List<String> carNameList, int racingRound){
        for(String carName : carNameList) {
            RacingCar car = new RacingCar(carName);
            racingCarList.add(car);
        }
        this.racingRound = racingRound;
    }

    void startRace() {
        RacingReporter reporter = new RacingReporter();

        for (int currentRound = 1; currentRound <= racingRound; currentRound++) {
            for ( RacingCar targetCar : racingCarList) {
                targetCar.move();
            }
            reporter.reportRoundResult();
        }
    }

}
