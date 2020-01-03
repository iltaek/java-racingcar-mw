public class RacingResultAnalyzer {
    static String winners;
    public void extractWinner() {
        int highScore = getHighScore();
        winners = getWinners(highScore);
    }

    private int getHighScore() {
        int currentHighScore = 0;
        for (RacingCar car : RacingManager.racingCarList) {
            if (currentHighScore < car.getDistance()) {
                currentHighScore = car.getDistance();
            }
        }

        return currentHighScore;
    }

    private String getWinners(int highScore) {
        String winners = "";

        for (RacingCar car : RacingManager.racingCarList) {
            if (highScore == car.getDistance()) {
                winners += car.toString() + ",";
            }
        }
        return winners.substring(0,winners.length()-1);
    }
}
