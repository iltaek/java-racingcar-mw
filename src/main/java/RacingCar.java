public class RacingCar {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Race race = inputView.getInputAndCreateRace();
        race.start();
    }
}
