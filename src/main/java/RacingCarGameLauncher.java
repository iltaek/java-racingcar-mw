import java.util.List;

public class RacingCarGameLauncher {
    public void launch(List<Car> carList, int numberOfExecution) {
        RacingCarGame racingCarGame = new RacingCarGame();
        RacingCarGameResult racingCarGameResult = new RacingCarGameResult();

        for (int i = 0; i < numberOfExecution; i++) {
            racingCarGame.playSingleGame(carList);
            racingCarGameResult.prepareIntermediateResult(carList);
        }

        List<Car> winnersList = getWinnersList(carList);
        racingCarGameResult.prepareFinalResult(winnersList);

        String result = racingCarGameResult.getResult();
        System.out.println(result);
    }

    private List<Car> getWinnersList(List<Car> carList) {
        RacingCarGameWinners racingCarGameWinners = new RacingCarGameWinners();
        return racingCarGameWinners.getWinners(carList);
    }
}
