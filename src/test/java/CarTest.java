import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("car가 랜덤 값을 받아서 4이상이면 true, 그렇지않으면 false를 반환하는지 테스트")
    public void goTest(){
        //given
        Car car = new Car("CarA");
        //when
        int randomNumber = car.go();
        //then
        assertThat(randomNumber >= 4).isEqualTo(car.record);
    }
}
