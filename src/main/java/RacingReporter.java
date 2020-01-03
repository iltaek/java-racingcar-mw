public class RacingReporter {

    static String accumulatedResult = "";

    public void reportRoundResult() {
        for (RacingCar car : RacingManager.racingCarList) {
            accumulatedResult +=
                car.toString() + ":" + expressDistanceAsCharacter(car.getDistance()) + "\n";
        }
        accumulatedResult += "\n";
    }

    private String expressDistanceAsCharacter(int distance) {
        String result = "";
        for (int i = 0; i < distance; i++) {
            result += RacingGame_Constant.RACING_DISTANCE_CHARACTER;
        }
        return result;
    }

}
