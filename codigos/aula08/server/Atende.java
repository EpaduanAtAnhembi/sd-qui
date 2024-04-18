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

    public void enviar(Mensagem msg) {
        try {
            comunicacao.send(msg);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        boolean online = true;
        System.out.println("Conectado com " + cliente.getInetAddress()+ "LP: " + cliente.getLocalPort() + "P:" + cliente.getPort());
        while (online) {
            Mensagem msg = (Mensagem) comunicacao.receive(); // casting
            
            if(msg == null) { // ao encerrar a conexão, vai receber um objeto nulo. Por isso, termina a thread
                online = false;
            } else {
                for (Atende atende : Servidor.atendentes) {
                    atende.enviar(msg);
                }
            }
        }
        Servidor.atendentes.remove(this);
        System.out.println("Fim da thread");
        System.out.println("Restaram " + Servidor.atendentes.size());
    }

}
