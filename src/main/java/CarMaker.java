import java.util.List;
import java.util.stream.Collectors;

public class CarMaker {

    public static Car makeCar(String name){
        return new Car(name);
    }

    public static List<Car> makeCars(List<String> names){
        return names.stream()
                .map(CarMaker::makeCar)
                .collect(Collectors.toList());
    }


}
