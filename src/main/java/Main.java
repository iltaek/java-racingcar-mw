import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    private static final String MESSAGE_1 = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MESSAGE_2 = "시도할 회수는 몇회인가요?";

    public static void main(String[] args) {
        System.out.println(MESSAGE_1);
        String input = scanner.nextLine();

        Verifier.checkInput(input);

        System.out.println(MESSAGE_2);
        int round = scanner.nextInt();

        Verifier.isNaturalNumber(round);

        RacingGame racingGame = new RacingGame(Arrays.asList(input.split(",")),round);

        racingGame.start();

        ResultPrinter.print(racingGame);

    }
}
