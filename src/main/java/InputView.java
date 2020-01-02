import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ERR_MSG = "잘못된 입력입니다.";
    private static final String INPUT_NUM_MSG = "시도할 횟수는 몇회인가요?";

    private static final Scanner sc = new Scanner(System.in);

    public Input view() {
        System.out.println(INPUT_CAR_MSG);
        String carListInput = sc.nextLine();
        while(!InputValidator.validateCarList(carListInput)) {
            System.out.println(INPUT_ERR_MSG);
            carListInput = sc.nextLine();
        }
        String tryNumberInput = sc.nextLine();
        while(!InputValidator.validateNumber(tryNumberInput)) {
            System.out.println(INPUT_ERR_MSG);
            tryNumberInput = sc.nextLine();
        }

        return new Input(carListInput.split(","), Integer.parseInt(tryNumberInput));
    }
}
