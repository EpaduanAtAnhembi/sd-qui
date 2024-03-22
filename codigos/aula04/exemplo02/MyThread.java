package exemplo02;

public class MyThread extends Thread {
    private Counter counter;
    private int number;

    public MyThread(Counter counter, int number) {
        this.counter = counter;
        this.number = number;
    }

    @Override
    public void run() {
        counter.count(number);
    }
}
