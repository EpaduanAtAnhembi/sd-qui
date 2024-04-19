package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Salas {
    private final Map<String, ArrayList<Atende>> salas = new HashMap<>();

    public boolean salaExiste(String nomeSala) {
        return (salas.get(nomeSala) != null);
    }

    public void novaSala(String nomeSala) {
        salas.put(nomeSala, new ArrayList<>());
    }

    public void novoClienteSala(String nomeSala, Atende atende) {
        salas.get(nomeSala).add(atende);
    }

    public ArrayList<Atende> getAtendentes(String nomeSala) {
        return salas.get(nomeSala);
    }

    public void removerAtende(String nomeSala, Atende atende) {
        salas.get(nomeSala).remove(atende);
    }
}
