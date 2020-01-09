import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ResultView {
    void printTitle() {
        System.out.println("실행 결과");
    }

    void printLocation(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName());
            System.out.print(" : ");
            for (int i=0; i<car.getLocation(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    void printWinner(List<Car> winner) {
        List<String> winnerName = winner.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println(String.format("%s가 최종 우승했습니다.", String.join(", ", winnerName)));
    }
}
