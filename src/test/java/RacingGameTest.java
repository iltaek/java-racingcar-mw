import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    public void 레이싱_게임_생성_테스트(){
        //given
        //when
        RacingGame racingGame = new RacingGame(Arrays.asList("CarA","CarB","CarC"), 5);
        //then
        assertThat(racingGame.getPlayers().size()).isEqualTo(3);
        assertThat(racingGame.getRound()).isEqualTo(5);
    }

    @Test
    public void 한_라운드_진행_테스트(){
        //given
        RacingGame racingGame = new RacingGame(Arrays.asList("CarA","CarB","CarC"), 5);
        //when

        //then
    }

    @Test
    public void 승자_반환_테스트(){
        //given
        RacingGame racingGame = new RacingGame(Arrays.asList("CarA","CarB","CarC"), 5);
        //when

        //then
    }
}
