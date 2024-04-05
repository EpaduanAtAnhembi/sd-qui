package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import util.Idioma;
import util.Status;
import util.Traducao;

public class Client {
    public static void main(String[] args) {
        final int PORT = 4321;
        Socket socketClient;
        Traducao pedidoTraducao, respostaTraducao;
        ObjectOutputStream output = null;
        ObjectInputStream input = null;
        String palavra = "";
        Scanner scanner = new Scanner(System.in);

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

            while (!palavra.equalsIgnoreCase("exit")) {

                System.out.println("Digite a apalavra para traduzir: ");
                palavra = scanner.nextLine();

                pedidoTraducao = new Traducao(palavra, Idioma.ING_PORT);
                output.writeObject(pedidoTraducao);

                respostaTraducao = (Traducao) input.readObject();

                if (respostaTraducao.getStatus() == Status.SUCESSO) {
                    System.out.println("Tradução: " + respostaTraducao.getPalavra());
                } else {
                    System.out.println("Palavra não encontrada");
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao trocar dados com o servidor");
        }

        // close
        try {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
            socketClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Cliente encerrado");
    }
}
