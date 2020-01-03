import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNamesSeparator {

    public static List getCarNameList(String unseparatedCarNames){
        List<String> carNameList;
        String[] separatedCarNames = unseparatedCarNames.split(RacingGame_Constant.DELIMITER_FOR_CAR_NAMES);
        carNameList = Arrays.asList(separatedCarNames);

        return carNameList;
    }
}
