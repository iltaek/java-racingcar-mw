import java.util.Scanner;

public class RacingCarGameInputReceiver {
    public String getCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������ �ڵ��� �̸��� �Է��ϼ���(�̸��� ��ǥ(,)�� �������� ����).");
        return scanner.nextLine();
    }

    public String getNumberOfExecution() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("�õ� �� Ƚ���� �� ȸ �ΰ���?");
        return scanner.nextLine();
    }
}
