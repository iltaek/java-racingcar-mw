import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class VerifierTest {

    @Test
    public void 라운드_음수_테스트() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Verifier.isNaturalNumber(-1));
    }

    @Test
    public void 라운드_제로_테스트() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Verifier.isNaturalNumber(0));
    }

    @Test
    public void 차이름_space_테스트(){
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Verifier.checkCarNames("a,b c"));
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Verifier.checkCarNames("a, b,c"));
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Verifier.checkCarNames("a ,b,c"));
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Verifier.checkCarNames(" a,b,c"));
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Verifier.checkCarNames("a,b,c "));
    }
    @Test
    public void 차이름_null_테스트(){
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Verifier.checkCarNames("a,,b,c"));
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Verifier.checkCarNames(",a,b,c"));
    }
}
