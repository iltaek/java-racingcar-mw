public class Verifier {

    public static void checkCarNames(String input) {
        if(input.contains(" ")){
            throw new IllegalArgumentException("이름에 공백을 포함할 수 없습니다. 입력값 : " + input);
        }
        String[] carNames = input.split(",");
        for(String carName : carNames){
            if("".equals(carName)){
                throw new IllegalArgumentException("모든 차에는 이름이 존재해야 합니다. 입력값 : " + input);
            }
        }
    }

    public static void isNaturalNumber(int round) {
        if(round < 1){
            throw new IllegalArgumentException("입력하신 값은 자연수가 아닙니다. 입력값 : " + round);
        }
    }
}
