import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("car가 go를 수행할 round수를 받고, 수행 결과를 List로 반환하는 테스트")
    public void goEveryRoundTest(){
        //given
        Car car = new Car("CarA");

        //when
        List<Boolean> record = car.goEveryRound(3);

        //then
        assertThat(record.size()).isEqualTo(3);

    }

    @Test
    @DisplayName("car가 랜덤 값을 받아서 4이상이면 true, 그렇지않으면 false를 반환하는 테스트")
    public void goEachRoundTest(){
        //given
        Car car = new Car("CarA");
        //when
        int randomNumber = car.goEachRound();
        //then
        assertThat(randomNumber >= 4).isEqualTo(car.record.get(0));
    }
}
