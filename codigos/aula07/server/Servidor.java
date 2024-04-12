package server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.dev.br>
 */
public class Servidor {

    public static void main(String[] args) {
        final int PORT = 9876;
        ServerSocket serverSocket;
        Socket cliente;

        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Aguardando novo cliente...");
                cliente = serverSocket.accept();
                Atende atende = new Atende(cliente);
                atende.start();
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
