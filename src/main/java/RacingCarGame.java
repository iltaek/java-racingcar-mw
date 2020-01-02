public class RacingCarGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Input input = inputView.view();
        GameController controller = new GameController(input);
        controller.start();
    }
}
