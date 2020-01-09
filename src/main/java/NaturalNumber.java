public class NaturalNumber extends Number implements Comparable<NaturalNumber>{
    private final int value;

    public NaturalNumber(String in) {
        int number = Integer.parseInt(in);
        if (number <= 0) {
            throw new IllegalArgumentException("입력된 값이 자연수가 아닙니다.");
        }
        this.value = number;
    }

    public NaturalNumber(int in) {
        if (in <= 0) {
            throw new IllegalArgumentException("입력된 값이 자연수가 아닙니다.");
        }
        this.value = in;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return value;
    }

    @Override
    public float floatValue() {
        return value;
    }

    @Override
    public double doubleValue() {
        return value;
    }

    @Override
    public int compareTo(NaturalNumber naturalNumber) {
        return compare(this.value, naturalNumber.value);
    }

    public static int compare(int n1, int n2)
    {
        return Integer.compare(n1, n2);
    }
}
