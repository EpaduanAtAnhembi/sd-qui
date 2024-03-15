import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Pessoa p1 = new Pessoa();
        // Pessoa p2 = new Pessoa("Marcela", 21);

        // System.out.println(p1.getNome());
        // System.out.println(p1.getIdade());
        // System.out.println(p2.getNome());
        // System.out.println(p2.getIdade());

        // Cliente c = new Cliente("Nicolas", 20, 1000);

        // System.out.println(c.getNome());

        ArrayList<Cliente> lista = new ArrayList<>();

        lista.add(new Cliente("c1", 10, 100));
        lista.add(new Cliente("c2", 11, 110));
        lista.add(new Cliente("c3", 12, 120));

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getNome());
        }

    }
}
