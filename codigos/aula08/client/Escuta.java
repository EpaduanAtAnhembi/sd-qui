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
    String sala;
    

    public Escuta(Socket socket, JTextArea txtHistorico, String sala) {
        this.socket = socket;
        this.txtHistorico = txtHistorico;
        this.sala = sala;
    }

    
    @Override
    public void run() {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            while (true) {
                Mensagem msg = (Mensagem) in.readObject();
                if(msg.getSala().equals(sala)) {
                    txtHistorico.append(msg.getNome() + "> " + msg.getTexto() + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
