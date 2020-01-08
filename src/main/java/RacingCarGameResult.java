import java.util.Iterator;
import java.util.List;

public class RacingCarGameResult {
    private final StringBuilder result = new StringBuilder();

    public RacingCarGameResult() {
        result.append("실행 결과 : ")
                .append("\n");
    }

    public void prepareIntermediateResult(List<Car> carList) {
        for (Car car : carList) {
            prepareCarMovementDrawing(car);
        }
        result.append("\n");
    }

    private void prepareCarMovementDrawing(Car car) {
        result.append(car)
                .append(" : ");

        for (int i = 0; i < car.getMovingDistance(); i++) {
            result.append("-");
        }
        result.append("\n");
    }

    public void prepareFinalResult(List<Car> winnersList) {
        String winnersName = getWinnersName(winnersList);

        result.append(winnersName)
                .append("이(가) 최종 우승 했습니다.");
    }

    public String getWinnersName(List<Car> winnersList) {
        StringBuilder winnerNames = new StringBuilder();

        Iterator<Car> iterator = winnersList.iterator();

        winnerNames.append(iterator.next());

        while (iterator.hasNext()) {
            winnerNames.append(", ")
                    .append(iterator.next());
        }

        return winnerNames.toString();
    }

    public String getResult() {
        return result.toString();
    }
}
