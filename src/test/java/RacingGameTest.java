import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RacingGameTest {

    RacingGame racingGame;

    @BeforeAll
    void makeRacingGame(){
        String input = "a,b,c,d,e";
        List<String> carNames = Arrays.asList(input.split(","));
        racingGame = new RacingGame(carNames,5);
    }


    @Test
    @Description("레이싱 스타트 테스트")
    void startTest(){

    }
}
