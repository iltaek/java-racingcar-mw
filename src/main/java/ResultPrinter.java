import java.util.Iterator;
import java.util.stream.IntStream;

public class ResultPrinter {

    public static void print(RacingGame racingGame) {
        System.out.print("\n실행 결과");

        IntStream.range(0, racingGame.getRound())
            .forEach(i -> {
                racingGame.getPlayers().forEach(c-> printEachRoundScore(c,c.getScores().get(i)));
                System.out.println();
            });

        printWinner(racingGame);
    }

    private static void printEachRoundScore(Car car, int score) {
        System.out.print("\n" + car.getName() + " : ");
        IntStream.range(0, score).forEach(i -> System.out.print("-"));
    }

    private static void printWinner(RacingGame racingGame) {
        Iterator<Car> iterator = racingGame.getWinner().iterator();

        System.out.print("\n" + iterator.next());
        while (iterator.hasNext()) {
            System.out.print(", " + iterator.next());
        }

        System.out.println("가 최종 우승했습니다.");
    }
}
