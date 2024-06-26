
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;

public class Server {

    public static void main(String[] args) {
        final int PORT = 4321;
        ServerSocket serverSocket;

        // binding = obter uma porta do Sistema Operacional
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor disponível na porta " + PORT);
        } catch (BindException e) {
            System.out.println("Erro. A porta " + PORT + " já está em uso. Altere a configuração em...");;
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // accept = esperar uma conexão de um cliente
        try {
            System.out.println("Aguardando um cliente...");
            serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // close = fechar a conexão
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Servidor encerrado.");
    }
}