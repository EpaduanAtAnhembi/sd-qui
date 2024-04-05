
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

import util.Status;
import util.Traducao;

public class Server {

    public static void main(String[] args) {
        final int PORT = 4321;
        ServerSocket serverSocket;
        Socket clientSocket;
        ObjectInputStream input;
        ObjectOutputStream output;
        Traducao pedidoTraducao, respostaTraducao;

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
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // troca de dados
        try {
            input = new ObjectInputStream(clientSocket.getInputStream());
            output = new ObjectOutputStream(clientSocket.getOutputStream());

            System.out.println("Aguardando mensagem...");
            pedidoTraducao = (Traducao) input.readObject();
            System.out.println("Palavra: " + pedidoTraducao.getPalavra());

            respostaTraducao = new Traducao("vermelho", Status.SUCESSO);
            output.writeObject(respostaTraducao);
            
        } catch (Exception e) {
            System.out.println("Erro ao receber os dados");
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