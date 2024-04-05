package client;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import util.Idioma;
import util.Traducao;

public class Client {
    public static void main(String[] args) {
        final int PORT = 4321;
        Socket socketClient;
        Traducao pedidoTraducao, respostaTraducao;
        ObjectOutputStream output;
        ObjectInputStream input;

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

        // troca de dados
        try {
            output = new ObjectOutputStream(socketClient.getOutputStream());
            input = new ObjectInputStream(socketClient.getInputStream());

            pedidoTraducao = new Traducao("red", Idioma.ING_PORT);
            output.writeObject(pedidoTraducao);

            respostaTraducao = (Traducao) input.readObject();
            System.out.println("Resposta: " + respostaTraducao.getPalavra());

        } catch (Exception e) {
            System.out.println("Erro ao trocar dados com o servidor");
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
