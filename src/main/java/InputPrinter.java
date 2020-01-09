public class InputPrinter {
    private static final String MESSAGE_1 = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MESSAGE_2 = "시도할 회수는 몇회인가요?";

    public static void carNameInputPrint(){
        System.out.println(MESSAGE_1);
    }
    public static void roundNumberInputPrint(){
        System.out.println(MESSAGE_2);
    }
}
