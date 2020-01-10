import java.util.Scanner;

public class InputView {
    private static String INPUT_NAME_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String INPUT_NUMBER_MSG = "시도할 회수는 몇회인가요\\?";
    Scanner sc = new Scanner(System.in);

    public Race getInputAndCreateRace() {
        System.out.println(INPUT_NAME_MSG);
        String carsName = sc.nextLine();
        while (carsName == null || carsName.isEmpty()) {
            carsName = sc.nextLine();
        }

        System.out.println(INPUT_NUMBER_MSG);
        NaturalNumber tryNum = null;
        try {
            tryNum = new NaturalNumber(sc.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값이 입력되었습니다: ");
            System.out.println(e.getCause().toString());
            System.exit(1);
        }
        return new Race(carsName.split(","), tryNum);
    }

    private boolean validateInput(String in) {
        if (in == null) return false;
        if (in.isEmpty()) return false;
        return true;
    }
}
