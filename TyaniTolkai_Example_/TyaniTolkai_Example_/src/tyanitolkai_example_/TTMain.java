package tyanitolkai_example_;

/**
 * ������� ������� ��������-����������-��������. �������� ���������� �����, ����������� ��� ��������, �������� ����������
 * ��� �������� ������� ������ ���� ����������������� � �������� ���������������
 */
public class TTMain {
    public static Producer p = null;
    public static Consumer c = null;

    public TTMain() {
    }

    public static void main(String[] args) {
        p = new Producer(1200);
        c = new Consumer(200);
        p.start();
        c.start();
    }
}
