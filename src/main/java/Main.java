import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String carNamesFromUserInput;
        String racingRoundFromUserInput;

        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        carNamesFromUserInput = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        racingRoundFromUserInput = scanner.nextLine();

        // Step1. user input validation. If user input is wrong, the program will exit with error message.
        UserInputValidator userInputValidator = new UserInputValidator(carNamesFromUserInput,
            racingRoundFromUserInput);
        userInputValidator.validate();

        // Step2. get racing information from user input and give it to RacingManager
        List<String> carNameList = CarNamesSeparator.getCarNameList(carNamesFromUserInput);
        int racingRound = Integer.parseInt(racingRoundFromUserInput);
        RacingManager manager = new RacingManager();
        manager.setRacingInformation(carNameList, racingRound);

        // Step3. Racing start.
        manager.startRace();


        // Step4. Racing Result
        RacingResultAnalyzer analyzer = new RacingResultAnalyzer();
        analyzer.extractWinner();

        // Step5. Announce result
        RacingAnnouncer announcer = new RacingAnnouncer();
        announcer.announceResult();
    }
}
