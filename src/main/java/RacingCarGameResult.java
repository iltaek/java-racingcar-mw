import java.util.Iterator;
import java.util.List;

public class RacingCarGameResult {
    private final StringBuilder result = new StringBuilder();

    public RacingCarGameResult() {
        result.append("실행 결과 : ")
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
        Iterator<Car> iterator = carList.iterator();

        Car firstCar = iterator.next();
        StringBuilder finalResult = new StringBuilder(firstCar.toString());
        int maxDistance = firstCar.getMovingDistance();

        while (iterator.hasNext()) {
            Car nextCar = iterator.next();

            if (nextCar.getMovingDistance() > maxDistance) {
                finalResult = new StringBuilder(nextCar.toString());
                maxDistance = nextCar.getMovingDistance();
            } else if (nextCar.getMovingDistance() == maxDistance) {
                finalResult.append(", ")
                        .append(nextCar);
            }
        }

        finalResult.append("이(가) 최종 우승 했습니다.");
        result.append(finalResult.toString());
    }

    public String getResult() {
        return result.toString();
    }
}
