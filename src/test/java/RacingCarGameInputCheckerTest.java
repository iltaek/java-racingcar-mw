import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCarGameInputCheckerTest {
    @ParameterizedTest
    @Description("��ǥ�� �������� ���̽�ī �̸��� ���� ���� �Է½� �ùٸ��� ������ ó���ϴ��� �׽�Ʈ.")
    @NullAndEmptySource
    @ValueSource(strings = {"", ",", "Car_1,", ",Car_1"})
    void emptyInputForCarNamesTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingCarGameInputChecker().checkCarNames(input))
                .withMessage("�ڵ��� �̸� �Է��� �߸��Ǿ����ϴ�. ������ �ƴ� �̸��� �Է����ּ���.");
    }

    @ParameterizedTest
    @Description("��ǥ�� �������� ���̽�ī �̸��� ���� �ߺ��� �̸� �Է½� �ùٸ��� ������ ó���ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"Car_1,Car_1", "Car_1,Car_2,Car_1"})
    void duplicatedNameInputForCarNamesTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingCarGameInputChecker().checkCarNames(input))
                .withMessage("�ڵ��� �̸� �Է��� �߸��Ǿ����ϴ�. �ߺ����� �ʵ��� ���� �ٸ� �̸��� �Է����ּ���.");
    }

    @ParameterizedTest
    @Description("�ڿ����� ǥ���Ǵ� ���� ���� Ƚ���� ���� ���� �Է½� �ùٸ��� ������ ó���ϴ��� �׽�Ʈ.")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void emptyInputForNumberOfExecutionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingCarGameInputChecker().checkNumberOfExecution(input))
                .withMessage("���� ���� Ƚ�� �Է��� �߸��Ǿ����ϴ�. �ڿ��� ���ڸ� �Է����ּ���.");
    }

    @ParameterizedTest
    @Description("�ڿ����� ǥ���Ǵ� ���� ���� Ƚ���� ���� �ڿ����� �ƴ� �� �Է½� �ùٸ��� ������ ó���ϴ��� �׽�Ʈ.")
    @ValueSource(strings = {"a", "#", ",", "/", "-3", "1 + 2", "3.14"})
    void nonNaturalNumberInputForNumberOfExecutionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingCarGameInputChecker().checkNumberOfExecution(input))
                .withMessage("���� ���� Ƚ�� �Է��� �߸��Ǿ����ϴ�. �ڿ��� ���ڸ� �Է����ּ���.");
    }
}
