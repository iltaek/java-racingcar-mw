import java.util.List;
import java.util.Random;

public class RacingGame {

    private final Random random = new Random(); //주사위
    private final List<Car> players;
    private final int round;

    public RacingGame(List<String> playerNames, int round) {
        players = CarMaker.make(playerNames);
        this.round = round;
    }

    public List<Car> getPlayers() {
        return players;
    }

    public int getRound() {
        return round;
    }
}
