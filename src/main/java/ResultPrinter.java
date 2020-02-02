import java.util.Iterator;
import java.util.stream.IntStream;

class ResultPrinter {

    static void print(RacingGame racingGame) {
        System.out.print("\n실행 결과");

        IntStream.range(0, racingGame.getRound())
            .forEach(i -> printAllPlayerEachRound(racingGame, i));
        printWinner(racingGame);
    }

    private static void printAllPlayerEachRound(RacingGame racingGame, int round) {
        racingGame.getCars().forEach(c -> printEachRoundScore(c, round));
        System.out.println();
    }

    private static void printEachRoundScore(Car car, int round) {
        System.out.print("\n" + car.getName() + " : ");

        int scoreOfSpecificRound = car.getScores().get(round);
        IntStream.range(0, scoreOfSpecificRound).forEach(i -> System.out.print("-"));
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
