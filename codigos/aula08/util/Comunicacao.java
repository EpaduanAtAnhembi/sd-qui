package util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/* 
 * Objetivo: Facilitar o envio e recebimento de mensagens padronizando e 
 * diminuindo a quantidade de código no cliente e no servidor
 */

public class Comunicacao {
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public Comunicacao(Socket socket) {
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println("Erro ao criar os objetos de comunicação : "+ e.getMessage());
        }
    }

    public void send(Object object) {
        try {
            out.writeObject(object);
        } catch (Exception e) {
            System.out.println("Erro ao enviar a mensagem: " + e.getMessage());
        }
    }

    public Object receive() {
        try {
            return in.readObject();
        } catch (Exception e) {
            System.out.println("Erro ao receber a mensagem: " + e.getMessage());
            return null;
        }
    }

}
