import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        InputPrinter.carNameInputPrint();
        String input = scanner.nextLine();
        Verifier.checkInput(input);

        InputPrinter.roundNumberInputPrint();
        int round = scanner.nextInt();
        Verifier.isNaturalNumber(round);

        RacingGame racingGame = new RacingGame(Arrays.asList(input.split(",")),round);
        racingGame.start();

        ResultPrinter.print(racingGame);

    }
}
