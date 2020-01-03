public class RacingCar {

    private String name;
    private int distance;

    RacingCar(String name) {
        this.name = name;
    }

    public void move() {
        if (Math.random() >= RacingGame_Constant.CONDITION_FOR_CAR_MOVE) {
            distance++;
        }
    }

    public int getDistance(){
        return distance;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
