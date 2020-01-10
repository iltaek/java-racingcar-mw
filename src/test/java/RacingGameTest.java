import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    public void 레이싱_게임_생성_테스트() {
        //given
        //when
        RacingGame racingGame = new RacingGame(Arrays.asList("CarA", "CarB", "CarC"), 5);
        //then
        assertThat(racingGame.getCars().size()).isEqualTo(3);
        assertThat(racingGame.getRound()).isEqualTo(5);
    }

    @Test
    public void 한_라운드_진행_테스트() {
        //given
        RacingGame racingGame = new RacingGame(Arrays.asList("CarA", "CarB", "CarC"), 5);
        //when
        racingGame.startOneRound();
        List<Car> cars = racingGame.getCars();
        //then
        assertThat(cars.get(0).getValues().size()).isEqualTo(1);
        assertThat(cars.get(1).getValues().size()).isEqualTo(1);
        assertThat(cars.get(2).getValues().size()).isEqualTo(1);
    }

    @Test
    public void 모든_라운드_진행_테스트() {
        //given
        RacingGame racingGame = new RacingGame(Arrays.asList("CarA", "CarB", "CarC"), 5);
        //when
        racingGame.start();
        List<Car> cars = racingGame.getCars();
        //then
        assertThat(cars.get(0).getValues().size()).isEqualTo(5);
        assertThat(cars.get(1).getValues().size()).isEqualTo(5);
        assertThat(cars.get(2).getValues().size()).isEqualTo(5);
    }

    @Test
    public void 승자_검색_및_반환_테스트() {
        //given
        RacingGame racingGame = new RacingGame(Arrays.asList("CarA", "CarB", "CarC"), 5);

        //when
        racingGame.start();
        List<Car> cars = racingGame.getCars();

        int carAScore = cars.get(0).getLastScore();
        int carBScore = cars.get(1).getLastScore();
        int carCScore = cars.get(2).getLastScore();
        List<Integer> scoreList = Arrays.asList(carAScore, carBScore, carCScore);

        int max = Collections.max(scoreList);
        int count = (int) scoreList.stream().filter(i -> i == max).count();

        //then
        assertThat(racingGame.getWinner().get(0).getLastScore()).isEqualTo(max);
        assertThat(racingGame.getWinner().size()).isEqualTo(count);
    }
}
