import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        final int PORT = 4321;
        Socket socketClient;

        // conection = solicitação de conexão com o host
        try {
            socketClient = new Socket("localhost", PORT);
            System.out.println("Conectado com o servidor");
        } catch (UnknownHostException e) {
            System.out.println("Host não encontrado");
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // close
        try {
            socketClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Cliente encerrado");
    }
}
