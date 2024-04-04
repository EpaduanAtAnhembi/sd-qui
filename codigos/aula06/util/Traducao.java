package util;

enum Idioma {
    PORT_ING, ING_PORT
}

enum Status {
    SUCESSO, NAO_ENCONTRADA
}

public class Traducao {
    private String palavra;
    private Idioma idioma;
    private Status status;

    public Traducao(String palavra, Idioma idioma) {
        this.palavra = palavra;
        this.idioma = idioma;
    }

    public Traducao(String palavra, Status status) {
        this.palavra = palavra;
        this.status = status;
    }

    public String getPalavra() {
        return palavra;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public Status getStatus() {
        return status;
    }

}
