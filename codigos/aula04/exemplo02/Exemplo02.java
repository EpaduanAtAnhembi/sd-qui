package exemplo02;

public class Exemplo02 {
    public static void main(String[] args) {

        Counter counter = new Counter();

        MyThread t1 = new MyThread(counter, 5);
        MyThread t2 = new MyThread(counter, 10);


        t1.start();
        t2.start();
    }
}
