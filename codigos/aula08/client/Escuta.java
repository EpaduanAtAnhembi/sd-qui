package client;

import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JTextArea;

import util.Mensagem;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.dev.br>
 */

public class Escuta extends Thread {
    Socket socket;
    ObjectInputStream in;
    JTextArea txtHistorico;
    

    public Escuta(Socket socket, JTextArea txtHistorico) {
        this.socket = socket;
        this.txtHistorico = txtHistorico;
    }

    
    @Override
    public void run() {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            while (true) {
                Mensagem msg = (Mensagem) in.readObject();
                txtHistorico.append(msg.getNome() + "> " + msg.getTexto() + "\n");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
