import java.util.List;


public class RacingGame {

    final List<Car> cars;
    final int round;

    public RacingGame(List<String> carNames, int round){
        this.cars = CarMaker.makeCars(carNames);
        this.round = round;
    }

    public List<Car> start(){

        for(int i = 0 ;i < round ;i ++){
            raceEachRound(cars);
        }
        return cars;
    }

    public void raceEachRound(List<Car> cars){
        cars.forEach(Car::go);
    }

}
