package server;

import java.net.Socket;

import util.Comunicacao;
import util.Mensagem;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.dev.br>
 */

public class Atende extends Thread {
    Socket cliente;
    Comunicacao comunicacao;
  
    public Atende(Socket socket) {
        cliente = socket;
        comunicacao = new Comunicacao(cliente);
    }

    @Override
    public void run() {
        boolean online = true;
        while (online) {
            Mensagem msg = (Mensagem) comunicacao.receive(); // casting
            
            if(msg == null) { // ao encerrar a conexão, vai receber um objeto nulo. Por isso, termina a thread
                online = false;
            } else {
                System.out.println(msg.getTexto());
                comunicacao.send(msg);
            }
        }
        System.out.println("Fim da thread");
    }

}
