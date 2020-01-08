import java.util.List;

public class RacingCarGameResult {
    private final StringBuilder result = new StringBuilder();

    public RacingCarGameResult() {
        result.append("���� ��� : ")
                .append("\n");
    }

    public void computeIntermediateResult(List<Car> carList) {
        for (Car car : carList) {
            computeCarMovementDrawing(car);
        }
        result.append("\n");
    }

    private void computeCarMovementDrawing(Car car) {
        result.append(car)
                .append(" : ");

        for (int i = 0; i < car.getMovingDistance(); i++) {
            result.append("-");
        }
        result.append("\n");
    }

    public void computeFinalResult(List<Car> carList) {
        RacingCarGameWinners racingCarGameWinners = new RacingCarGameWinners();
        int maxDistance = 0;

        for (Car car : carList) {
            maxDistance = racingCarGameWinners.updateMaxDistance(car, maxDistance);
        }

        result.append(racingCarGameWinners.getWinnersName())
                .append("��(��) ���� ��� �߽��ϴ�.");
    }

    public String getResult() {
        return result.toString();
    }
}
