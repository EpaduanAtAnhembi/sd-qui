package exemplo01;

public class MyThread extends Thread {
    
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Início da thread " + getName());

        try {
            sleep(2000); // coloca para 'dormir' por 2 segundos
        } catch (Exception e) {
            System.out.println("Erro no sleep");
        }

        System.out.println("Final da thread " + getName());
    }
}
