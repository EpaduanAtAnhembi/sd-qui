package client;

import java.io.ObjectInputStream;
import java.net.Socket;

import util.Mensagem;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.dev.br>
 */

public class Escuta extends Thread {
    Socket socket;
    ObjectInputStream in;

    public Escuta(Socket socket) {
        this.socket = socket;
    }

    
    @Override
    public void run() {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            while (true) {
                Mensagem msg = (Mensagem) in.readObject();
                System.out.println(msg.getTexto());
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
