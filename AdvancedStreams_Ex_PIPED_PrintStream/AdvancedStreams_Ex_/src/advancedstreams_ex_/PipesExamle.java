package advancedstreams_ex_;

import java.io.*;

public class PipesExamle {
    public PipesExamle() {
    }

    public static void main(String[] args) {

        try{
            //������ ������������ ����������� �� ���� �����������
            /*PrintStream p = new PrintStream(new FileOutputStream("out.txt"), false);
            System.setOut(p);*/
            //������������� ������� - ����
            final int SIZE = 1000;//������������ ������ ������ ��� ������, �.�. ����� ����� = 1024, � ������ ����� ������ - 24
            PipedOutputStream pipeOut = new PipedOutputStream();
            PipedInputStream pipeIn = new PipedInputStream(pipeOut);

            PrintStream old = System.out;
            System.setOut(new PrintStream(pipeOut));
            //�� �������!!!!!
            int count = 0;
            int i=0;
            while (count<SIZE) {
         System.out.print(1231231);
                String txt = "step #" + (i + 1)+/*System.getProperty("line.separator")*/"\n";//��� ������ � ���� ������� ������ ����� ����������� �����������
                System.out.print(txt);
                count+=txt.length();
                i++;
                //old.println(count);
            }
            //--------------
            System.setOut(old);
            System.out.println("--------------------------------------");
            System.out.println("PipedInputStream supports mark/reset: "+pipeIn.markSupported());
            BufferedInputStream in = new BufferedInputStream(pipeIn, SIZE+24);//��������� ��������������� ������
            System.out.println("BufferedInputStream supports mark/reset: "+in.markSupported());
            //������ � �������
            in.mark(SIZE+24);
           System.out.println(in.available()+"ssssssssssssssssssssssssssssssssssssssssssssssssss");
            while (in.available()>0){
                System.out.write(in.read());
            }
            //������ � ����
            in.reset();
            //������ ������� �������� ������
            /*PushbackInputStream push = new PushbackInputStream(in, SIZE*2);
            System.out.println("PushbackInputStream supports mark/reset: "+push.markSupported());
            int[] buf = new int[SIZE*2];
            int index = 0;
            while (push.available()>0){
                char c = (char)push.read();
                if (c=='\n'){
                    buf[index++] = '\r';//��������� ������ ��� ����� ������
                }
                buf[index++] = c;
            }
            for (int j = index - 1; j >= 0; j--) {
                push.unread(buf[j]); //���������� ������ ����� � �����
            }
            FileOutputStream fOut = new FileOutputStream("out.txt");
            while (push.available()>0){
                fOut.write(push.read());
            }*/
            in.close();
            pipeOut.close();
        } catch (Exception ex){
            ex.printStackTrace(System.out);
        }
    }
}

