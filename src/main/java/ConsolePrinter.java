import com.google.common.base.Preconditions;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ConsolePrinter {

    public static void print(List<Car> cars, int round) {
        System.out.print("\n실행 결과");
        for (int i = 1; i <= round; i++) {
            for (Car car : cars) {
                printUntilSpecificRound(car, i);
            }
            System.out.println();
        }
        printWinner(cars);

    }

    private static void printUntilSpecificRound(Car car, int round) {
        Preconditions.checkNotNull(car);

        System.out.print("\n" + car.getName() + " : ");

        for (int i = 0; i < round; i++) {
            if (car.getScore().get(i)) {
                System.out.print("-");
            }
        }
    }

    private static void printWinner(List<Car> cars) {
        List<Car> winnerCars = cars.stream().filter(Car::isWinner).collect(Collectors.toList());

        Iterator<Car> iterator = winnerCars.iterator();

        System.out.print("\n" + iterator.next());
        while (iterator.hasNext()) {
            System.out.print(", " + iterator.next());
        }

        System.out.println("가 최종 우승했습니다.");
    }
}
