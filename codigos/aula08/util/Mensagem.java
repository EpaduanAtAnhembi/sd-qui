package util;

import java.io.Serializable;

/**
 *
 * @author Emerson S. Paduan <emerson@paduan.dev.br>
 */

public class Mensagem implements Serializable {

    private String nome, texto, sala;

    public Mensagem(String nome, String texto, String sala) {
        this.nome = nome;
        this.texto = texto;
        this.sala = sala;
    }

    public String getNome() {
        return nome;
    }

    public String getTexto() {
        return texto;
    }

    public String getSala() {
        return sala;
    }
}
