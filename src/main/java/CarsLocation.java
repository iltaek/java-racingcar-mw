import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CarsLocation {
    Map<Car, Integer> carsLocation = new HashMap<Car, Integer>();

    public CarsLocation(Car[] cars) {
        Arrays.asList(cars)
                .stream()
                .forEach(c -> carsLocation.put(c, 0));
    }
}
